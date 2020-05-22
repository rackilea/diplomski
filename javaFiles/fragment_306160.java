public class Foo {
    public String getBar() {
        ...
    }
}

public class FooComparatorByBar implements Comparator<Foo> {
    public int compare(Foo x, Foo y) {
        // TODO: Handle null values of x, y, x.getBar() and y.getBar(),
        // and consider non-ordinal orderings.
        return x.getBar().compareTo(y.getBar());
    }
}