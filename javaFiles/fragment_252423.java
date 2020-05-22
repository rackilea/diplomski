task otherTest(type: Test) {
    testClassesDir = sourceSets.otherTest.output.classesDir
    classpath += sourceSets.otherTest.runtimeClasspath
}

check.dependsOn otherTest