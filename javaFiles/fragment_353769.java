File target = new File( System.getProperty( "java.io.tmpdir" ), <filename> );
InputStream  is =
   getClass().getClassLoader().getResourceAsStream( <path to rc> );
OutputStream os = new FileOutPutStream( target );
<copy is to os>
Process p = new ProcessBuilder( target ).start();