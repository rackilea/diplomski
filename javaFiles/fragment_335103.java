task bamm(type: Copy) {
  description "Creates BAMM plugin."
  println "Creates BAMM plugin."
  println "Copies artifacts from " + project.libsDir + " to " + gradle.bammDir
  from(project.libsDir)
  into(gradle.bammDir)
}