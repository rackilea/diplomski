public class WildcardTest {
    interface Thing< T > {
        void consume( T t );
    }
    private < T > Thing< T > make( Class< T > c ) {
        return new Thing< T >() {
            @Override public void consume(T t) {}
        };
    }
    private < T > void makeAndConsume( Object t, Class< T > c ) {
        make( c ).consume( c.cast( t ) );
    }

    private void blah() {
        Class< ? extends WildcardTest > wc = this.getClass();
        make( wc ).consume( wc.cast( this ) ); // won't compile! (capture#2 and capture#3)
        makeAndConsume( this, wc );            // compiles
    }
}