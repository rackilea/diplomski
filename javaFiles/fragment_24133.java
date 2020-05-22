sourceSets {
    generated
    main {
        compileClasspath += generated.output  // adds the sourceSet to the compileClassPath
        runtimeClasspath += generated.output  // adds the sourceSet to the runtimeClasspath
    }
}

project.run.classpath += sourceSets.generated.output //add the sourceSet to project class path