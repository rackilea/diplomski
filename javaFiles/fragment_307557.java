public class AbstractLambda<T> extends Abstract<T>
{
    private final Supplier<? extends T> supplier;
    public AbstractLambda(Supplier<? extends T> supplier)
    {
        this.supplier = supplier;
    }

    @Override
    public T getSomething()
    {
        return this.supplier.get();
    }
}