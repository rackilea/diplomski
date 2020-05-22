class MyClass<T>
{
    private Class<T> clazz;

    MyClass(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    // Now you can use clazz to check for instances, create new instances ect.
}