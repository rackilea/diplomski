apply plugin: MyPlugin

class MyPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
       project.tasks.create(name: "myTask", type: Copy) {
       }
    }
}