public class Bar {
    private List<Foo<?>> list;

    public <T> Foo<T> getFoo(Class<T> type, String name) {
        // find elem which matches the name
        return type.cast(listElement);
    }
}