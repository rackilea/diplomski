public class Whatever<T> {
    private List<T> list;
    private Foo<T> baz;

    public void bazToList() {
        list.add(baz.bar());
    }

    public void listToBaz() {
        baz.foo(list.get(1));
    }
}