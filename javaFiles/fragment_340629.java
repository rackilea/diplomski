public class Foo {
    private final Bar bar = new Bar();
    public class Bar {
        private final Abc abc = new Abc();
        public class Abc {
            @RequiredParam private final String property = "Result.";
        }
    }
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface RequiredParam {}
}