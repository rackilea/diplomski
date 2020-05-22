package name.seller.rich.maven.plugins.bootstrap;

import java.util.List;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.factory.ArtifactFactory;
import org.apache.maven.artifact.repository.ArtifactRepository;
import org.apache.maven.artifact.resolver.ArtifactNotFoundException;
import org.apache.maven.artifact.resolver.ArtifactResolutionException;
import org.apache.maven.artifact.resolver.ArtifactResolver;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Obtain the artifact defined by the groupId, artifactId, and version
 * from the remote repository.
 * 
 * @goal bootstrap
 */
public class BootstrapAppMojo extends AbstractMojo {

    /**
     * Used to look up Artifacts in the remote repository.
     * 
     * @parameter expression=
     *  "${component.org.apache.maven.artifact.factory.ArtifactFactory}"
     * @required
     * @readonly
     */
    protected ArtifactFactory factory;

    /**
     * Used to look up Artifacts in the remote repository.
     * 
     * @parameter expression=
     *  "${component.org.apache.maven.artifact.resolver.ArtifactResolver}"
     * @required
     * @readonly
     */
    protected ArtifactResolver artifactResolver;

    /**
     * List of Remote Repositories used by the resolver
     * 
     * @parameter expression="${project.remoteArtifactRepositories}"
     * @readonly
     * @required
     */
    protected List remoteRepositories;

    /**
     * Location of the local repository.
     * 
     * @parameter expression="${localRepository}"
     * @readonly
     * @required
     */
    protected ArtifactRepository localRepository;

    /**
     * The target pom's artifactId
     * 
     * @parameter expression="${bootstrapArtifactId}"
     * @required
     */
    private String bootstrapArtifactId;

    /**
     * The target pom's groupId
     * 
     * @parameter expression="${bootstrapGroupId}"
     * @required
     */
    private String bootstrapGroupId;

    /**
     * The target pom's type
     * 
     * @parameter expression="${bootstrapType}"
     * @required
     */
    private String bootstrapType;

    /**
     * The target pom's version
     * 
     * @parameter expression="${bootstrapVersion}"
     * @required
     */
    private String bootstrapVersion;

    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            Artifact pomArtifact = this.factory.createArtifact(
                bootstrapGroupId, bootstrapArtifactId, bootstrapVersion,
                "", bootstrapType);

            artifactResolver.resolve(pomArtifact, this.remoteRepositories,
                this.localRepository);
        } catch (ArtifactResolutionException e) {
            getLog().error("can't resolve parent pom", e);
        } catch (ArtifactNotFoundException e) {
            getLog().error("can't resolve parent pom", e);
        }
    }
}