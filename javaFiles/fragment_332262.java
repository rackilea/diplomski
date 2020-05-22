apply plugin: 'java'
apply plugin: 'jetty'

repositories {
    mavenCentral()
}

sourceSets {
    selenium
}

dependencies {
    seleniumCompile 'junit:junit:4.11'
    seleniumCompile 'org.seleniumhq.selenium:selenium-java:2.30.0'
}

task jettyDaemon(type: org.gradle.api.plugins.jetty.JettyRun) {
    daemon = true
}

task selenium(type: Test, dependsOn: jettyDaemon) {
    testClassesDir = sourceSets.selenium.output.classesDir
    classpath = sourceSets.selenium.runtimeClasspath
}