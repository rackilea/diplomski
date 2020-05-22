buildscript {
    repositories { mavenCentral() }
    dependencies { classpath "io.spring.gradle:dependency-management-plugin:0.5.4.RELEASE" }
}

allprojects {
    apply plugin: "io.spring.dependency-management"
}