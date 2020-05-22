buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
   classpath "de.gesellix:gradle-docker-plugin:2017-10-05T20-48-17"
  }
}

apply plugin: de.gesellix.gradle.docker.DockerPlugin

import de.gesellix.gradle.docker.tasks.DockerBuildTask
import de.gesellix.gradle.docker.tasks.DockerTask