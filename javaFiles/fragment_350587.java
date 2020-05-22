import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

import java.nio.charset.StandardCharsets
import java.time.ZoneOffset
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

plugins {
  id "application" // https://docs.gradle.org/current/userguide/application_plugin.html
  id "com.github.johnrengelman.shadow" version "5.1.0" // Shadow here ;)
  id "eclipse"
  id "idea"
  id "java"
  id "com.github.johnrengelman.shadow" version "5.1.0"
  id "org.flywaydb.flyway" version "5.2.4"
  id "org.springframework.boot" version "2.1.6.RELEASE"
}

// apply from: "another.gradle"
// apply plugin: "io.spring.dependency-management"

group = "io.shido"
version = "0.0.1-SNAPSHOT"
description = "Container-based Spring Boot Application"

sourceCompatibility = JavaVersion.VERSION_1_8
targetCompatibility = JavaVersion.VERSION_1_8

configurations {
  // all*.exclude module: "spring-boot-starter-tomcat"
}

repositories {
  // mavenLocal() // Uncomment when needed
  jcenter()
}

dependencies {
  //-----------------------------------------------------------------------------------------------
  // Experimental Dependencies
  //-----------------------------------------------------------------------------------------------

  //-----------------------------------------------------------------------------------------------
  // BOM Support
  //-----------------------------------------------------------------------------------------------

  implementation platform("org.springframework.boot:spring-boot-dependencies:2.1.6.RELEASE")

  //-----------------------------------------------------------------------------------------------
  // Project Dependencies
  //-----------------------------------------------------------------------------------------------

  implementation "org.apache.commons:commons-lang3"
  implementation "org.springframework.boot:spring-boot-starter-data-jpa"
  implementation "org.springframework.boot:spring-boot-starter-validation"
  implementation "org.springframework.boot:spring-boot-starter-web"

  runtimeOnly "com.h2database:h2" // FIXME: Must change/delete this for the real driver/dependency
  runtimeOnly "org.flywaydb:flyway-core"
  runtimeOnly "org.springframework.boot:spring-boot-starter-actuator" // FIXME: Very careful with this one ;)

  //-----------------------------------------------------------------------------------------------
  // Test Dependencies
  //-----------------------------------------------------------------------------------------------

  testImplementation "nl.jqno.equalsverifier:equalsverifier:3.1.9"
  testImplementation "org.assertj:assertj-core"
  testImplementation "org.junit.jupiter:junit-jupiter-engine"
  testImplementation "org.mockito:mockito-core"
  testImplementation "org.springframework.boot:spring-boot-starter-test"
}

//=================================================================================================
//  P L U G I N S
//=================================================================================================

application {
  mainClassName = "io.shido.Application"
}

//=================================================================================================
//  T A S K S
//=================================================================================================

tasks.withType(Jar) {
  final def attrs = [
    "Application-Name": project.name,
    "Build-Date": ZonedDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME),
    //"Build-Number": ,
    "Created-By": System.getProperty("user.name"),
    "Gradle-Version": gradle.gradleVersion,
    "Implementation-Title": project.name,
    "Implementation-Vendor": "Vendor Here",
    "Implementation-Version": project.version, // ...should be the build number
    "Specification-Title": project.name,
    "Specification-Vendor": "Vendor Here",
    "Specification-Version": project.version,
    "JDK-Version": System.getProperty("java.version"),
  ]
  manifest { attributes(attrs) }
}

tasks.withType(JavaCompile) {
  options.encoding = "${StandardCharsets.UTF_8}"
}

tasks.withType(Test) {
  testLogging {
    events = [TestLogEvent.FAILED, TestLogEvent.SKIPPED]
    exceptionFormat = TestExceptionFormat.FULL
    showCauses = true
    showExceptions = true
    showStackTraces = true
  }
  useJUnitPlatform()
}

//-------------------------------------------------------------------------------------------------
// Custom Tasks
//-------------------------------------------------------------------------------------------------