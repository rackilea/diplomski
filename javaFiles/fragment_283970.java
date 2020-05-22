jar {
  from {
        (configurations.runtime - configurations.providedCompile).collect {
            it.isDirectory() ? it : it
        }
    } 
}