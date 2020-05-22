public class LazyFormat {

    public static void main(String[] args) {
        Object o = lazyFormat("some texts %s with patterns %s", "looong string", "another loooong string");
        System.out.println(o);
    }

    private static Object lazyFormat(final String s, final Object... o) {
        return new Object() {
            @Override
            public String toString() {
                return String.format(s,o);
            }
        };
    }
}