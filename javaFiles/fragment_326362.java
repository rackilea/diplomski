public class Singleton {
    private static final class Constants {
        static final String CONSTANT_1 = "Foo";
        static final String CONSTANT_2 = "Bar";
        static final String CONSTANT_3 = "Baz";
        static final String CONSTANT_4 = "etc";

        private Constants() { throw new AssertionError(); }
    }

    // …

    // Use the constants either via Constants.CONSTANT_1, etc.
    // or using import static Singleton.Constants.*; and
    // unqualified names ala CONSTANT_1, CONSTANT_2, etc.

    // …
}