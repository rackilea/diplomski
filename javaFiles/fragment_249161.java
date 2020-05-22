buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "net.ltgt.gradle:gradle-apt-plugin:0.3"
  }
}

apply plugin: "net.ltgt.apt"

dependecies {
  apt 'com.google.dagger:dagger-compiler:2.0.1'
  compile 'com.google.dagger:dagger:2.0.1'
}