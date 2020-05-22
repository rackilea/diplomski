public class MyPluginTask extends DefaultTask {
    @TaskAction
    public void action() {
        MyPluginExtensions extensions = (MyPluginExtensions) getProject()
                .getExtensions().findByName("myPluginName");

        System.out.println("sourceDir value: " + extensions.sourceDir);
    }
}