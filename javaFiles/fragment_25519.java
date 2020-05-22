public static void main( String[] args ) throws Exception {
    try { 
        ProcessBuilder pb = new ProcessBuilder( "/bin/bash", "-c",
                   "echo one >/tmp/xxx && echo two >>/tmp/xxx && " +
                   "if [ -s /tmp/xxx ]; then cp /tmp/xxx /tmp/yyy; fi" );
        File log = new File( "/tmp/log.txt" );
        pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
        Process process = pb.start();
        process.waitFor();
    } catch( Exception e ){
        // ...
    } catch( Error e ){
        // ...
    }
}