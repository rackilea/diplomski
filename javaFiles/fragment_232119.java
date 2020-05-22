Options options = new Options();
Option option = Option.builder("a")
    .longOpt( "block-size" )
    .desc( "use SIZE-byte blocks"  )
    .hasArg()
    .argName( "SIZE" )
    .build();
options.addOption( option );