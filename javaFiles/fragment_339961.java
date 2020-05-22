public class SomeClass<T extends Exception>
{
    private final T value;

    public SomeClass(T value)
    {
        this.value = value;
    }

    public T getValue()
    {
        return this.value;
    }
}