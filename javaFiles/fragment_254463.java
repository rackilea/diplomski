public class MyImplementations {

    public static final MyInterface<Integer> FOO =
            new MyInterface<Integer>() {
                ...
            };

    public static final MyInterface<String> BAR =
            new MyInterface<String>() {
                ...
            };

    public static final MyInterface<List<MyOtherType>> BAZ =
            new MyInterface<List<MyOtherType>>() {
                ...
            };

    private MyImplementations() { }
}