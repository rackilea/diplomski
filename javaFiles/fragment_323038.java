public class FooComparator implements Comparator<Foo> {

    public int compare( Foo first, Foo second ) {
        return first.getAccessible().compareTo( second.getAccessible() );
    }
}