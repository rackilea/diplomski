public class Main {
    public static void main(String[] args) {
        Foo<String> foo = new Foo<String>(1000);
        foo.a[0] = foo.new Entry();
        foo.a[0].key = "ss";
    }
}

class Foo<Key extends Comparable<Key>> {
    public Entry[] a;

    public class Entry {
        Key key;
    }

    public Foo(int size) {
        a = (Entry[]) java.lang.reflect.Array.newInstance(Entry.class, size);
    }
}