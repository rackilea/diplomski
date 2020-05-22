public class Some {
    public static void main( String [] args ) {
        if ( Some.class.isInstance( new SubClass() ) ) {
            System.out.println( "ieap" );
        } else { 
            System.out.println( "noup" );
        }
    }
}
class SubClass extends Some{}