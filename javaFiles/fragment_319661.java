import java.util.function.Function;

class MinimalTypeFailureExample {

    void foo() {
        transform((Function<Integer, String>)null, o -> i -> {return "";});
    }

    <T, F> void transform(F f, MyFunction<T, ? extends F> m) {}

}

@FunctionalInterface
interface MyFunction<T, R> extends Function<T, R> {
    @Override
    R apply(T t);
}