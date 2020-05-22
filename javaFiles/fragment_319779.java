@Test
   public void test() throws IOException {
      String output = "";
      String sInOut;
      String sErr;
      //      RunCommandDto runCommandDto = new RunCommandDto();

      String[] cmd = { "sh", "~/ssh_key_gen.sh"};

      Runtime rt = Runtime.getRuntime();
      Process proc = rt.exec( cmd );

      BufferedReader stdInput = new BufferedReader( new InputStreamReader( proc.getInputStream() ) );
      BufferedReader stdError = new BufferedReader( new InputStreamReader( proc.getErrorStream() ) );
      while ( (sInOut = stdInput.readLine()) != null ) {
         output += sInOut + "\n";
      }

      while ( (sErr = stdError.readLine()) != null ) {
         output += sErr + "\n";
      }

      System.out.println("if failed: " + output);
   }