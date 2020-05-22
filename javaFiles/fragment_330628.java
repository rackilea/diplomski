function jarPath(){
      variables.jarPath = createObject( "java", "java.io.File" ).init( 
      createObject( "java", "runwar.LaunchUtil"  )
      .getClass()
      .getProtectionDomain()
      .getCodeSource()
      .getLocation()
      .toURI()
      .getSchemeSpecificPart() )
    .getAbsolutePath();

    job.start(serialize(variables.jarPath));
    job.complete();

  }