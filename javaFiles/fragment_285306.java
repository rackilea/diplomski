buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "gradle.plugin.aspectj:gradle-aspectj:0.1.6"
  }
}

project.ext {
  aspectjVersion = "1.8.2"
}

apply plugin: "aspectj.gradle"