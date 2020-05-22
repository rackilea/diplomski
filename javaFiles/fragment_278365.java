public class Test {

    // Do not optimize this
    public static volatile String A = "A String";

    public static void main( String [] args ) throws Exception {

        String a1 = A + "B";

        String a2 = A + 'B';

        a1.equals( a2 );

    }

}