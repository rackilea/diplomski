private Class<?>[] types;

public void foo(Class<?>... types)
{
    this.types = types;
}

public boolean bar(Object... values)
{
    if (values.length != types.length)
    {
        System.out.println("Wrong length");
        return false;
    }
    for (int i = 0; i < values.length; i++)
    {
        if (!types[i].isInstance(values[i]))
        {
            System.out.println("Incorrect value at index " + i);
            return false;
        }
    }
    return true;
}