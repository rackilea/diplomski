buildscript {
  repositories {
    mavenLocal()
  }

  dependencies {
    classpath('io.spring.gradle:dependency-management-plugin:0.6.0.RELEASE')
    classpath('org.springframework.boot:spring-boot-gradle-plugin:1.4.2.RELEASE')
  }
}

plugins {
  // ...
}

//apply from: 'gradle/database.gradle'

apply plugin: 'idea'
apply plugin: 'io.spring.dependency-management'
apply plugin: 'java'
apply plugin: 'org.springframework.boot'

repositories {
  mavenCentral()
  jcenter()
}

configurations {
  all*.exclude module: 'spring-boot-starter-logging'
  //all*.exclude module: 'jboss-logging-annotations'
  //all*.exclude module: 'jboss-logging'
}

dependencyManagement {
  imports {
    mavenBom("org.springframework.boot:spring-boot-dependencies:1.4.2.RELEASE")
  }
}

dependencies {
  compile 'com.lmax:disruptor:3.3.5'
  compile 'org.springframework.boot:spring-boot-starter-actuator'
  compile 'org.springframework.boot:spring-boot-starter-log4j2'
  compile 'org.springframework.boot:spring-boot-starter-undertow'
  compile 'org.springframework:spring-webmvc'
}

task wrapper(type: Wrapper) {
  gradleVersion '3.2.1'
}