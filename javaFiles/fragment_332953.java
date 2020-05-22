import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Story {
   public static void main( String[] args ) throws FileNotFoundException {
      Scanner     sc    = new Scanner( System.in );
      Scanner     input = new Scanner( new File( "Story.txt" ));
      PrintStream out   = new PrintStream( "Story-out.txt" );
      while( input.hasNext()) {
         String current      = input.next();
         String cstStrBefore = "";
         String cstStrAfter  = "";
         int openIndex = current.indexOf( "<" );
         boolean var = ( openIndex > -1 );
         if( var ) {
            int closeIndex = current.indexOf( ">" );
            cstStrBefore = current.substring( 0, openIndex );
            cstStrAfter  = current.substring( closeIndex + 1 );
            current      =
               current.substring( openIndex + 1, closeIndex - openIndex );
         }
         System.out.println( current );
         switch( current ) {
         case "adjective"  : System.out.print( "Please enter an adjective: " ); break;
         case "plural-noun": System.out.print( "Please enter a plural noun: " ); break;
         case "noun"       : System.out.print( "Please enter a noun: " ); break;
         case "place"      : System.out.print( "Please enter a place: " ); break;
         }
         if( var ) {
            current = sc.next();
         }
         out.print( cstStrBefore + current + cstStrAfter + ' ' );
      }
      sc.close();
      input.close();
      out.close();
   }
}