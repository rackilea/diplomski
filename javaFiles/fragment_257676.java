public class ReleasePlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getTasks().create("ggrelease", GGReleaseTask.class);
    }
}