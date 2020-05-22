public class Outer<A> {

    Inner in;

    Outer( A a ) {
        in = new Inner( a );
    }

    Inner get() {
        return in;
    }

    class Inner {
        A value;

         Inner( A value ) {
            this.value = value;
        }
    }

    public static void main( String[] args ) {
        String s = new Outer<>( "test" ).get().value;
        //And to declare an variable Inner
        Outer<String>.Inner i = new Outer<>( "test" ).get();
    }
}