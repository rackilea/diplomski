buildscript {
  repositories { jcenter() }
  dependencies {
    classpath 'com.github.jengelman.gradle.plugins:shadow:1.2.1'
  }
}
apply plugin: 'com.github.johnrengelman.shadow'
shadowJar {
  mergeServiceFiles()
}