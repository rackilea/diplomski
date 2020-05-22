public class Project {

    private TestTwo example;

    public void onEnable() {
        this.example = new TestTwo(this);
        this.example.printFromProject();
    }

    public int getSample() {
        return 1337;
    }
}

public class TestTwo {

    private final Project project;

    public TestTwo(Project project) {
        this.project = project;
    }

    public void printFromProject() {
        System.out.println(this.project.getSample());
    }

}