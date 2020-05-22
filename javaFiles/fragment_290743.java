version '1.0-SNAPSHOT'
  apply plugin: 'java'
  apply plugin: 'application'
  apply plugin: 'com.github.johnrengelman.shadow'

  group = 'your.package.path.here'
  version = '0.0.1-SNAPSHOT'

  mainClassName = 'your.package.path.here.MainClassName'

  buildscript {
      repositories {
          jcenter()
      }
      dependencies {
          classpath 'com.github.jengelman.gradle.plugins:shadow:2.0.1'
      }
  }


  dependencies {
      compile(group: 'org.springframework', name: 'spring-core', version:'4.3.11.RELEASE') 
  }

  repositories {
      mavenCentral()
 }

 jar {
 doFirst {
    manifest {
        if (!configurations.compile.isEmpty()) {
            attributes(
                    'Class-Path':configurations.compile.collect{it.toURI().toString()}.join(' '),
                    'Main-Class': 'your.package.path.here.MainClassName')

        }
    }
}