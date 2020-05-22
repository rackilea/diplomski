buildscript {
  repositories {
    mavenCentral()
  }

  dependencies {
    classpath 'com.google.guava:guava:18.0'
  }
}

apply plugin: LolPlugin

class LolPlugin implements Plugin<Project> {
  public void apply(Project p) {
    p.buildscript.dependencies.each {
      println it
    }
    p.buildscript.configurations.classpath.each {
      println it
    }
  }
}