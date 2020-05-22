public class Test {

    public static void main( String [] args ) throws Exception {

        Collection<?> val = null;

        List<?> single = testSingle( val ); // OK

        List<List<?>> pair = testList( val ); // ERROR

    }

    static <T> List<T> testSingle( Collection<T> val ){
        return null;
    }

    static <T> List<List<T>> testList( Collection<T> val ){
        return null;
    }

}