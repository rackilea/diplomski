public static void main( String[] args ) throws Exception {
  try { 
    ProcessBuilder pb = new ProcessBuilder( "/bin/ps", "-ef" );
    Process process = pb.start();
    InputStream is = process.getInputStream();
    Reader rdr = new InputStreamReader( is );
    LineNumberReader lnr = new LineNumberReader(rdr);
    String line;
    while( (line = lnr.readLine()) != null ){
      if( line.contains( "skype" ) ){
        System.out.println( "skype is running" );
      }
    }
    process.waitFor();
  } catch( Exception e ){

  } catch( Error e ){

}