buildscript {
    repositories {
        maven {
            url "https://plugins.gradle.org/m2/"
        }
    }
    dependencies {
        classpath "net.ltgt.gradle:gradle-apt-plugin:0.4"
    }
}

apply plugin: "net.ltgt.apt"
apply plugin: 'java'
apply plugin: 'idea'

repositories {
    mavenCentral()
}

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.12'

    compile 'com.google.dagger:dagger:2.0.1'
    apt 'com.google.dagger:dagger-compiler:2.0.1'
}