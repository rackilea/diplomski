import java.lang.reflect.InvocationTargetException;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

@XmlRootElement(name="artifact")
public class Artifact {

    private String groupId;
    private String artifactName;
    private String version;

    public Artifact(final String groupId,final String artifactName,final String version) {
        super();
        this.groupId = groupId;
        this.artifactName = artifactName;
        this.version = version;
    }

    public Artifact(final String artifactName,final String version) {
        super();
        this.artifactName = artifactName;
        this.version = version;
    }

    public Artifact() {}

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name="groupId")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(final String groupId) {
        this.groupId = groupId;
    }
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name="artifactId")
    public String getArtifactName() {
        return artifactName;
    }

    public void setArtifactName(final String artifactName) {
        this.artifactName = artifactName;
    }
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(name="version")
    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
    @Override
    public boolean equals(final Object other){

        try {
            if(PropertyUtils.getProperty(other, groupId).equals(PropertyUtils.getProperty(this,groupId))
                    && PropertyUtils.getProperty(other, version).equals(PropertyUtils.getProperty(this,version))
                    && PropertyUtils.getProperty(other, artifactName).equals(PropertyUtils.getProperty(this,artifactName))) {

                return true;
            }
        } catch (IllegalAccessException e) {
            return false;
        } catch (InvocationTargetException e) {
            return false;
        } catch (NoSuchMethodException e) {
            return false;
        }
        return false;
    }
    @Override
    public int hashCode() {
        return groupId.hashCode() ^ artifactName.hashCode() ^ version.hashCode();
    }
}
--------------------------------


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.client.RestTemplate;

import artifact.model.Artifact;
import artifact.model.SearchNGResponse;

/**
 * Lucene Search ref: https://repository.sonatype.org/nexus-indexer-lucene-plugin/default/docs/path__lucene_search.html
 * Repo Url used for checksums : http://repository.opencastproject.org/nexus/content/repositories/public
 * e.g. - http://repository.opencastproject.org/nexus/service/local/lucene/search?a={artifactName}&v={artifactVersion}"
 * 
 * Class to search artifact/jar GAV coordinates by reading the pom.properties file or their checksums.
 */


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="searchNGResponse")
public class SearchNGResponse {

    private List<Artifact> artifacts = new ArrayList<Artifact>();

    @XmlElementWrapper(name ="data")
    @XmlElement(name ="artifact")
    public List<Artifact> getArtifacts(){
        return artifacts;
    }
}

-----------------------

public abstract class ArtifactDetailsExtractor {

    public abstract void generateMavenScript(final List<Artifact> artifact);
    public abstract void generateIvyScript(final List<Artifact> artifact);
    public abstract void generateGradleScript(final List<Artifact> artifact);

    private static final String searchRepo2Location ="http://repository.opencastproject.org/nexus/service/local/lucene/search?sha1={checksumString}";

    public enum ArtifactParams{
        GROUPID("groupId"),
        ARTIFACTID("artifactId"),
        VERSION("version"),
        JAR_EXTENSION("jar"),
        PROPERTIES_EXTENSION("pom.properties");

        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        private ArtifactParams(final String name) {
            this.name=name;
        }           
    }

    public List<Artifact> generateArtifactList(final String directory) throws Exception  { 

         final File folder = new File(directory);
         final File[] files = folder.listFiles();


         final Set<File> allArtifacts = new HashSet<File>();
         for (final File artifactLoaded : files) {
             final String jarFileExtension= FilenameUtils.getExtension(artifactLoaded.getName());

                if (artifactLoaded.isFile() && artifactLoaded.canRead()
                        && (jarFileExtension.equalsIgnoreCase(ArtifactParams.JAR_EXTENSION.getName()))) {
                    allArtifacts.add(artifactLoaded);
                }
         }

         final List<Artifact> artifacts=generateAndFindJar(allArtifacts);           
         return Collections.unmodifiableList(artifacts);
   }

    private List<Artifact> generateAndFindJar(final Set<File> missingArtifacts) throws IOException {

        final List<Artifact> artifacts = new ArrayList<Artifact>();

        final Set<File> availableArtifacts = new HashSet<File>();
        final RestTemplate restTemplate = new RestTemplate();
        for(File f: missingArtifacts) {
            final InputStream is = new FileInputStream(f);
            final  String checksumString = org.apache.commons.codec.digest.DigestUtils.sha1Hex(is);
            final SearchNGResponse result = restTemplate.getForObject(searchRepo2Location, SearchNGResponse.class, checksumString);
            if(result!=null && !result.getArtifacts().isEmpty()) {
                artifacts.add(result.getArtifacts().get(0));    
                availableArtifacts.add(f);
            }else {     
                final Set<String> groupDetails = new HashSet<String>();
                final JarFile jarFile = new JarFile(f);                 
                final Enumeration<JarEntry> entries = jarFile.entries();

                while (entries.hasMoreElements()) {
                    final JarEntry entry = entries.nextElement();

                    if(entry.getName().contains(ArtifactParams.PROPERTIES_EXTENSION.getName())) {
                        final Properties artifactProp = new Properties();
                        final InputStream input = jarFile.getInputStream(entry); 
                        artifactProp.load(input);
                        groupDetails.add(artifactProp.getProperty(ArtifactParams.GROUPID.getName()));
                        final Artifact artifact = new Artifact(artifactProp.getProperty(ArtifactParams.GROUPID.getName()),
                                artifactProp.getProperty(ArtifactParams.ARTIFACTID.getName()),
                                artifactProp.getProperty(ArtifactParams.VERSION.getName()));
                        artifacts.add(artifact);
                        availableArtifacts.add(f);
                    }
                }                   
                jarFile.close();

            }                       
        }
        missingArtifacts.removeAll(availableArtifacts);
        generateUnavailableArtifactList(missingArtifacts);

        return Collections.unmodifiableList(artifacts);
    }

    private void generateUnavailableArtifactList(final Set<File> badArtifacts) {
        System.out.println("number of jar files failed      : "+badArtifacts.size());
        try {
            final PrintWriter  writer = new PrintWriter(new OutputStreamWriter(
                      new FileOutputStream("artifact.txt"), "utf-8"));
            for(final File artifact: badArtifacts) {
                writer.println(artifact.getName());
                System.out.println("jar files failed   -----  : "+artifact.getName());
            }
            writer.close();

        } catch (final IOException ex) {
            ex.printStackTrace(); 
            System.err.println("Exception while finding unavailable  dependencies , must exit process : " + ex.getMessage());
            System.exit(1);
        } 
    }

}