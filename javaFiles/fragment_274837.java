String systemProperties = "-Dkey=value";    
ProcessBuilder pb = new ProcessBuilder( "java", systemProperties, "-jar", "test.jar", Integer.toString( jobId ), Integer.toString( software ), Integer.toString( entryPoint ), application );
pb.directory( new File("/home/userName/TestBSC") );
Process proc = pb.start();

InputStreamConsumerThread inputConsumer = 
     new InputStreamConsumerThread(proc.getInputStream(), true);
InputStreamConsumerThread errorConsumer = 
     new InputStreamConsumerThread(proc.getErrorStream(), true);

inputConsumer.start();
errorConsumer.start();

System.out.println( "Job running" );
proc.waitFor(); // wait until jar is finished
System.out.println( "Job finished" );

String processOutput = inputConsumer.getOutput();
String processError = errorConsumer.getOutput();

if(!processOutput.isEmpty()){
    //there were some output
}

if(!processError.isEmpty()){
    //there were some error
}