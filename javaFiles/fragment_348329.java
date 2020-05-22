buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.1.6.RELEASE")
    }
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply plugin: 'java'
    apply plugin: 'idea'
}