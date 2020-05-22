task findModule {
    subprojects {
        project -> project.afterEvaluate {
            println(project.name + ": " + project.ext.has('cons'))
            println(project.name + ": " + project.hasProperty('cons'))
        }
    }
}