task clearVersionProperties() << {
    println "Clearing version file"
    String whatToWrite = "version=@version@"
    writeVersionFile(whatToWrite)
}

task writeVersionProperties(dependsOn: [svnRevision]) << {
    println "Writing version file"
    String whatToWrite = "version="+project.ext.revision;
    writeVersionFile(whatToWrite)
}

writeVersionProperties.mustRunAfter clearVersionProperties