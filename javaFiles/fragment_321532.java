class SomeClass<T>
{
    /* ... other methods ... */

    private Map<T,T> aSet;

    public T filter(Object value)
    {
        // Will return the properly-typed object if it's in
        // the "set" otherwise will return null
        return aSet.get(value);
    }
}