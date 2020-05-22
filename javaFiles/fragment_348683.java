public <T> String methodName(Class<T> c, T obj) 
{
    method1(c);
    method2(obj);

    return "some string";
}

void method1(Class c) 
{
   // Some stuff.
}