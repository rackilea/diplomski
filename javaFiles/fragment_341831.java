public class Foo {
   static String g1[] = { "001",   "010",  "100" };
   static String g2[] = { "0001", "0010", "0100", "1000" };

   static void blarch( String digits ) {
      System.out.println("digits="+digits);
      int N = digits.length(); // use N for max index
      String sequence[][] = new String[ N ][];
      int counts[] = new int[ N ];
      for( int i = 0; i < N; ++i ) {
         char c = digits.charAt(i);
         sequence[i] = ( c == '7' || c == '9' ) ? g2 : g1;
         counts[i] = 0; // emphasize we're counting from zero.
      }
      boolean printStuff = true;
      while( printStuff ) {
         for( int i = 0; i < N; ++i ) {
            if( i >= 1 ) System.out.print( " " );
            //System.out.print( "<i="+i+", counts[i]="+counts[i]+">");
            System.out.print( sequence[i][ counts[i] ] );
         }
         System.out.println();
         // increment, watch for overflow - done if we "overflow" on seq[0];
         for( int i = N - 1; i >= 0; --i ) {
            if( ++counts[i] < sequence[i].length ) break;
            // overflow, we're done when seq#0 overflows.
            if( i == 0 ) printStuff = false;
            counts[i] = 0; // start this 'sequence' over at zero
         }
      }
   }

   public static void main(String args[]) {
      blarch( "27" );
      //blarch( "274" );
   }
}