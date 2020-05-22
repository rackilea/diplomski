@Mojo(name = "write-csv")
public class WriteToFsMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}", readonly = true)
    private MavenProject project;

    @Parameter(property = "outputFile", defaultValue = "someFileName.csv")
    private String filePath;

    public void execute() throws MojoExecutionException {
        File outputFile = new File(project.getBasedir(), filePath);
        // now do something with it
    }
}