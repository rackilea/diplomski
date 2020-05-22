public class TypeSafe {

    public static <T> boolean areEqual(T x, T y) {
        return x.equals(y);
    }

    void test() {
        TypeSafe.areEqual("a", 1); // Compiles because no restriction is present.
                                   // Both are resolved to Serializable
                                   // [there is not only "Object" in common ;)]

        TypeSafe.<CharSequence>areEqual("a", 1); // Does not compile
        //                                   ^
        //          Found: int, required: java.lang.CharSequence
    }
}