buildscript{
    repositories{
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath 'no.nils:wsdl2java:0.10'
    }
}

subprojects {
    apply plugin: 'java'
    apply plugin: 'eclipse'
    apply plugin: 'maven-publish'
    apply plugin: 'application'
    apply plugin: 'no.nils.wsdl2java'
    ....
}