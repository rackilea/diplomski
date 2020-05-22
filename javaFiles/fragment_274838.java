ProcessBuilder pb = new ProcessBuilder( "java", "-jar", "test.jar", Integer.toString( jobId ), Integer.toString( software ), Integer.toString( entryPoint ), application );
pb.directory( new File("/home/userName/TestBSC") );
pb.redirectErrorStream(true); // redirect error stream to output stream
pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
Process proc = pb.start();

System.out.println( "Job running" );
//since process builder will handle the streams for us
//we can call waitFor() safely
proc.waitFor(); 
System.out.println( "Job finished" );