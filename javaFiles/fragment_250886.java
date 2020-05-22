public class MyPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {

        Map<String,Object> taskInfo = new HashMap<String,Object>();
        taskInfo.put("type", MyPluginTask.class);
        taskInfo.put("description", "Generates blah from blah.");
        taskInfo.put("group", "Blah");
        Task myPluginTask = project.task(taskInfo, "myPluginTask");

        // Define conventions and attach them to tasks
        MyPluginExtensions extensions = new MyPluginExtensions(project);

        // the magic extension code:
        project.getExtensions().add("myPluginName", extensions);
    }
}