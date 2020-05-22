task bamm << {
  description "Creates BAMM plugin."
  println "Creates BAMM plugin."
  println "Copies artifacts from " + project.libsDir + " to " + gradle.bammDir
  copy {
     from(project.libsDir)
     into(gradle.bammDir)
  }
}