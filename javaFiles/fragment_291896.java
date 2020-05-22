apply plugin: 'java'
apply plugin: 'application'

mainClassName = 'br.com.myproject.Sample'
sourceCompatibility = '1.8'
[compileJava, compileTestJava]*.options*.encoding = 'UTF-8'
version='1.0.0'

// For DEBUG to work
ext.mainClass = mainClassName

repositories {
    mavenCentral()
}

dependencies {
    compile 'org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.1.1'
    testCompile group: 'junit', name: 'junit', version: '4.10'
}

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.github.jengelman.gradle.plugins:shadow:1.2.4'
    }
}

apply plugin: 'com.github.johnrengelman.shadow'