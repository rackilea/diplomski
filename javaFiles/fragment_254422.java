private void open( File file ) {
   try {
      final String cmd =
         String.format( "cmd.exe /C start %s", file.getAbsolutePath());
      Runtime.getRuntime().exec( cmd );
   }
   catch( final Throwable t ) {
      t.printStackTrace();
   }
}