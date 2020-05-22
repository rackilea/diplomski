@Mojo(name = "foo")
public class MyMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        // this is the main artifact file
        File file = project.getArtifact().getFile();
        getLog().info(file.toString());
    }

}