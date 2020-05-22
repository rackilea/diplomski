apply plugin: 'java'

sourceSets {
    integrationTest {
        java.srcDir 'src/testInteg/java'
        resources.srcDir 'src/testInteg/resources'
    }
}

configurations {
    integrationTestImplementation.extendsFrom testImplementation
    integrationTestRuntimeOnly.extendsFrom testRuntimeOnly
}

task integrationTest(type: Test) {
    testClassesDirs = sourceSets.integrationTest.output.classesDirs
    classpath = sourceSets.integrationTest.runtimeClasspath + sourceSets.test.runtimeClasspath
}

repositories {
    jcenter();
}

dependencies {
    implementation "org.projectlombok:lombok:1.18.6"

    testImplementation "junit:junit:4.11"

    integrationTestAnnotationProcessor "org.projectlombok:lombok:1.18.6"
}