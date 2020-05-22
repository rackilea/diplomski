// reconfigure the Java plugin's `jar` task
jar {
    exclude '**/a1/**'
    baseName = 'X1'
}

// need to configure this one from scratch
task x2jar(type: Jar) {
    // referring to the output in this way
    // allows Gradle to infer task dependencies automatically
    from sourceSets.main.output 

    exclude '**/a2/**'
    baseName = 'X2'
}

// one way to make `gradle build` run both Jar tasks
assemble.dependsOn(x2jar)