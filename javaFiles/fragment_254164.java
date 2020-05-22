public final class Param<T>
{
    private final String name;
    private T value;
    private Class<? extends T> type;
    public Param(String name, Class<? extends T> type)
    {
        this.name = name;
        this.type = type;
    }

    public boolean isString() {
        return String.class.isAssignableFrom(type);
    } 
}