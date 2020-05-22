task createProperties(dependsOn: processResources) {
  doLast {
    new File("$buildDir/resources/main/version.properties").withWriter { w ->
        Properties p = new Properties()
        p['version'] = project.version.toString()
        p.store w, null
    }
  }
}

classes {
    dependsOn createProperties
}