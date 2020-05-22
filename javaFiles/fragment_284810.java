// Set sourceCompatibility
if (project.hasProperty('javaVersion')) {
    project.sourceCompatibility = project.javaVersion
}

// Set bootClasspath - but wait until after evaluation, to have all tasks defined
project.afterEvaluate {
    if (project.hasProperty('javaPath')) {
        project.tasks.withType(AbstractCompile, {
            it.options.bootClasspath = "${project.javaPath}/jre/lib/rt.jar"
        })
    }
}

// Configure Eclipse .classpath
project.eclipse.classpath.file.whenMerged { Classpath cp ->
    if (project.hasProperty('jdkName') {
        cp.entries.findAll { it.path.contains('JRE_CONTAINER') }.each {
            it.path += "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/$project.jdkName"
        }
    }
}