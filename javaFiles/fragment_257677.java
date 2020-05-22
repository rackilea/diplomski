public class ReleasePlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.task("ggrelease");
    }
}