public interface UOWProcessor<T> {
    public default Integer countUOW(T args) {
        return 1;
    }
}

public class ListUOWProcessor implements UOWProcessor<List<?>> {
    // ...
    @Override
    public Integer countUOW(List<?> args) {
        for (Object arg : args) {
            total += uowProcessor.countUOW(arg);
        }

        return total;
    }
}