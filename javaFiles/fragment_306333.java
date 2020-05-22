configure(allprojects) {
  println "applying java plugin to $project"
  apply plugin: 'java-library'

  //...
}