class Rt { 
   public static void main(String args[]) throws Exception {

      Writer output     = new BufferedWriter(new FileWriter ( "write.txt"));
      InputStream in    = new ProcessBuilder("javap", "java.lang.String").start().getInputStream();
      BufferedReader br = new BufferedReader( new InputStreamReader(in)); 
      String line = null;
      while( ( line = br.readLine() )   != null ) {
          output.write( line );
      }
      output.close();
  }
}