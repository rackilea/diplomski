import java.util.Arrays;

public class VarargsExample {

    public static void foo( Object... args ) { 
        System.out.println( "foo: "+Arrays.toString( args ));
    }

    public static void bar( Object[] args ) {
        System.out.println( "bar: "+Arrays.toString( args ));
    }

    public static void main(String[] args) {
        // only foo can be called with variable arity arguments
        foo( 1, 2, 3 );
        // bar( 4, 5, 6 ); // won't compile 

        // both methods can be called with object arrays
        foo( new Object[] { 7, 8, 9 } );
        bar( new Object[] { 10, 11, 12 } );

        // so both can be called with List#toArray results
        foo( Arrays.asList( 13, 14, 15 ).toArray() );
        bar( Arrays.asList( 16, 17, 18 ).toArray() );
    }
}