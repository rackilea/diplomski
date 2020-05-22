public static void main( String[] args )
{
  StringBuilder cla = new StringBuilder();

  for( String command : args ) {
     cla.append( command );
     cla.append( '\n' );  // newline
  }
  String finalCommand = cla.toString();
}