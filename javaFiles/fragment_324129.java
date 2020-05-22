apply plugin: "java"
apply plugin: "eclipse"

sourceCompatibility = 1.8
sourceSets.main.java.srcDirs = [ "src/" ]

dependencies {
  compile "some.company:lib-name:version"
}