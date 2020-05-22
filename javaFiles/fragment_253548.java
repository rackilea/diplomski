buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath 'com.bmuschko:gradle-nexus-plugin:2.3'
    }
}

apply plugin: 'java'
apply plugin: 'maven'
apply plugin: 'com.bmuschko.nexus'
apply from: '../repos.gradle'

dependencies {
        compile project(':config')
}