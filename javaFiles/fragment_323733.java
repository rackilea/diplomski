task myTask () {     
    def deps = project.configurations['runtimeClasspath'].resolvedConfiguration.firstLevelModuleDependencies;
     for (d in deps) { 
        println "dep: $d with $d.moduleArtifacts" 
        def artifact = d.moduleArtifacts.find { it.classifier } ?: d.moduleArtifacts[0]
         if (artifact != null) { 
            println "f: $artifact  -> ${artifact.file}"         
        } else {
             println "f is null" 
        }     
    }
 }