public class ScannerStream {

   static String testVector = "//create applet instance\n" +
"0x80 0xB8 0x00 0x00 0x0c 0x0a 0xa0 0x00 0x00 0x00 0x62 0x03 0x01 0xc 0x01 0x01 0x00 0x7F;";

   public static void main( String[] args ) {
      List<List<Integer>> commands = new ArrayList<>();
      Scanner fileReader = new Scanner( new StringReader( testVector ) );
      while( fileReader.hasNextLine() ) {
         String line = fileReader.nextLine();
         if( line.startsWith( "0x" ) ) {
            List<Integer> out = Pattern.compile( "[\\s;]+" ).splitAsStream( line )
                    .map( Integer::decode ).collect( Collectors.toList() );
            System.out.println( out );
            commands.add( out );
         }
      }
      System.out.println( commands );
   }
}