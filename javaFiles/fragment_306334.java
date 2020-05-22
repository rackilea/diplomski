configure(allprojects) {
  if (getPath() != "absolute/path/to/new/project") {
    println "applying java plugin to $project"
    apply plugin: 'java-library'

    // ...
  }
}