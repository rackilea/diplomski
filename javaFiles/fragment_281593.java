buildscript {
    repositories {
        maven {
            url "https://maven.eveoh.nl/content/repositories/releases"
        }
    }

    dependencies {
        classpath "nl.eveoh:gradle-aspectj:1.4"
    }
}

project.ext {
    aspectjVersion = '1.8.4'
}

apply plugin: 'aspectj'

project.convention.plugins.java.sourceCompatibility = org.gradle.api.JavaVersion.VERSION_1_7
project.convention.plugins.java.targetCompatibility = org.gradle.api.JavaVersion.VERSION_1_7