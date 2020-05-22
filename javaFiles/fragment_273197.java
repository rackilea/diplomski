public class WildcardTest {
    private < T > void two( Class< T > t1, Class< T > t2 ) {}
    private < T > void one( Class< T > t1 ) {
        two( t1, t1 ); // compiles; no wildcards involved
    }
    private void blah() {
        two( WildcardTest.class, WildcardTest.class ); // compiles
        one( WildcardTest.class );                     // compiles

        Class< ? extends WildcardTest > wc = this.getClass();
        two( wc, wc ); // won't compile! (capture#2 and capture#3)
        one( wc );     // compiles
    }
}