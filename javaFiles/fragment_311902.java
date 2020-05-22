apply plugin: MyPlugin

myConfig {
    srcDir = 'lol'
}

class MyTask extends DefaultTask {

    @InputFiles 
    FileCollection srcFiles

    @TaskAction
    def task() {
        println srcFiles
    }
}

class MyPluginExtension {
    String srcDir = null
}

class MyPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create('myConfig', MyPluginExtension)
        project.tasks.create(name: "firstTask", type: MyTask) 
    }
}

firstTask {
    srcFiles = project.files(project.fileTree(dir: project.myConfig.srcDir, include: "**/*.java"))
}