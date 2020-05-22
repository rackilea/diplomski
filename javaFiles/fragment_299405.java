CommandLine cmdLine = new CommandLine("ping");
cmdLine.addArgument( host );

ByteArrayOutputStream stdout = new ByteArrayOutputStream();
PumpStreamHandler     psh    = new PumpStreamHandler( stdout );

DefaultExecutor executor = new DefaultExecutor(); 
executor.setStreamHandler( psh );

try {
  executor.execute( cmdLine );
} catch ( Exception e ) {
}

System.out.println( stdout.toString() );