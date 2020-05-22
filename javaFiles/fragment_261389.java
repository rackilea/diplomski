buildscript {
   // EDIT
   repositories {
       // ...
       jcenter()
   }
  dependencies {
    // ...
    classpath "org.jfrog.buildinfo:build-info-extractor-gradle:latest.release"  // <- this line is missing in your script
  }
}

apply plugin: 'java'
apply plugin: 'war'
apply plugin: 'maven'
apply plugin: 'maven-publish'
apply plugin: "com.jfrog.artifactory"  // <-- this one is missing in your script