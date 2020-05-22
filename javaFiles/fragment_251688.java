buildscript {   
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath "eu.schnuckelig.gradle:gradle-jaxws-plugin:1.0.2"
    }
}

apply plugin: 'maven'
apply plugin: 'jaxws'

System.setProperty('javax.net.ssl.trustStore', 'cacerts')
System.setProperty('javax.net.ssl.trustStorePassword', 'changeit')