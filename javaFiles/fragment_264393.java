eclipse {
  classpath {
    defaultOutputDir = file('classes')

      file {                
        whenMerged { classpath ->
          classpath.entries.findAll { entry -> entry.kind == 'lib' }*.exported = true                    
      }

    }
  }
}