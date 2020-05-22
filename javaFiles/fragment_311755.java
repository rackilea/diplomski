import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TungstenX
 */
public class VersionInfo {
    private static final Logger LOG =    Logger.getLogger(VersionInfo.class.getName());
    private static final String PROJECT = "MySEProject";
    private static final String COMPANY = "MyCompany";
    private static Manifest MANIFEST;

    /**
     * Get the version number from the manifest file
     * @return The version number or '--'
     */
    public static String GetVersionNumber() {
        if (MANIFEST == null) {
            try {
                Enumeration<URL> resources = VersionInfo.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
                while (resources.hasMoreElements()) {
                    URL url = resources.nextElement();
                    try(InputStream is = url.openStream()) {
                        Manifest tmpManifest = new Manifest(is);
                        for (Object o : tmpManifest.getMainAttributes().keySet()) {
                            if (o.toString().equals("Package-Title") 
                                    && tmpManifest.getMainAttributes().getValue(o.toString()).startsWith(COMPANY)
                                    && tmpManifest.getMainAttributes().getValue(o.toString()).endsWith(PROJECT)) {
                                MANIFEST = tmpManifest;
                            } 
                        }
                    } catch (Exception e) {
                        LOG.log(Level.SEVERE, "Error while reading manifest files: {0}", e.toString());
                    }
                }
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Error while reading manifest files: {0}", e.toString());
            }
        }
        if(MANIFEST != null) {
            return MANIFEST.getMainAttributes().getValue("Implementation-Version");
        } else {
            return "--";
        }
    }