task deleteJar(type: Delete) {
    delete 'libs/my-main-class.jar'
}

task createJar(type: Copy) {
    from('build/intermediates/bundles/debug/')
    into('libs/')
    include('classes.jar')
    rename('classes.jar', 'my-main-class.jar')
}

// This is the task that I call with ./gradlew to execute my jar
task runMyJar(type: JavaExec) {
    classpath files('libs/my-main-class.jar')
    classpath files('libs/common-util.jar')
    main 'com.example.MyMainClass'
    args = ["param1","param2"]
    outputs.upToDateWhen { false }
}

createJar.dependsOn(deleteJar, build)
runMyJar.dependsOn(createJar, build)