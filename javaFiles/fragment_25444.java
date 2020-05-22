public interface SomeClass<E> {
    public boolean test(E arg);
}

public class IsOdd implements SomeClass<Integer> {
    @Override
    public boolean test(Integer arg) {
        return arg % 2 == 1;
    }
}