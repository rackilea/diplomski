`task integrationTest(type: Test) {jacoco {
    append = true
    destinationFile = file("$buildDir/jacoco/jacocoTest.exec")
    classDumpFile = file("$buildDir/jacoco/classpathdumps")
}
 testClassesDir = sourceSets.integrationTest.output.classesDir
classpath = sourceSets.integrationTest.runtimeClasspath}`