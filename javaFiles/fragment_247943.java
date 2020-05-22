plugins {
    id 'com.gradle.build-scan' version '1.8' 
    //   id 'java'
    id 'application'
    id "org.jetbrains.kotlin.jvm" version "1.1.51"
    id 'com.github.johnrengelman.shadow' version '2.0.1'
}

buildScan {
    licenseAgreementUrl = 'https://gradle.com/terms-of-service'
    licenseAgree = 'yes'
    //publishAlways()
}

configurations {
    provided
}

shadowJar {
    baseName = 'kotlinAdder'
    classifier = null
    version = null
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

mainClassName = 'net.bounceme.dur.kotlin.App'

repositories {
    jcenter()
}

configurations {
    provided
}

dependencies {
    compile "org.jetbrains.kotlin:kotlin-stdlib:1.1.51"
}