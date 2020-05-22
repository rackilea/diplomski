public class TypeInference {

    static long getLong() { return 1L; }

    static <R> void with(Supplier<R> supplier, R value) {}
    static <R, F extends Supplier<R>> void withX(F supplier, R value) {}

    public static void main(String[] args) {
        with(TypeInference::getLong, "Not a long");       // Compiles
        withX(TypeInference::getLong, "Also not a long"); // Does not compile
    }

}