import java.util.BitSet;

public class p {

   static StringBuilder sb;

   // Add one and return true on overflow
   static boolean inc( BitSet s, int maxlen ) {

      int i = 0;
      for( ; i < maxlen; ++i ) {

         if( s.get( i )) { s.clear( i ); }
         else            { break; }
      }

      if( i == maxlen )
         return true;

      s.set( i );
      return false;
   }

   static String form( String x, String y, BitSet mask ) {

      sb.setLength( 0 );
      for( int i = 0; i < x.length(); ++i )
         sb.append( (mask.get( x.length() - i - 1) ? y : x).charAt( i ));

      return sb.toString();
   }

   public static void perms( String x, String y ) {

      assert( x.length() == y.length() );

      BitSet bits = new BitSet( x.length() );

      do {
         System.out.println( form( x, y, bits ));
      } while( ! inc( bits, x.length() ));
   }


   public static void main( String[] args ) {

      sb = new StringBuilder( args[0].length() );
      perms( args[0], args[1] );
   }
}