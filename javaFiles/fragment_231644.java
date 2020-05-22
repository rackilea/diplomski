import java.util.function.Function;

public class Example {
    @SomeAnnotation(SomeFunction.class)
    private static class SomeClass {

    }

    private @interface SomeAnnotation {
        Class<? extends Function> value();
    }

    private static class SomeFunction<T> implements Function<T, String> {
        @Override
        public String apply(T t) {
            return t.toString();
        }
    }
}