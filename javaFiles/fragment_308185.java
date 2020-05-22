public interface {
    public PagedCollection<Result> findByRange(@NotNull BigInteger start, @NotNull BigInteger end);
}


public class MyServiceImpl implements MyService
    @Override
    public PagedCollection<Result> findByRange(BigInteger start, BigInteger end)
    {
        if (start.compareTo(end) > 0)
            throw new IllegalArgumentException("a > b"); // I haven't yet created an annotation for that

        ...
    }
}