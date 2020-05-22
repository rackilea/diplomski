public OtherClass(Class<?> clazz, Object obj)
{
    // do some stuff...

    // Call method from obj
    Method method = clazz.getMethod("callback", SomeObject.getClass());
    method.invoke(obj, SomeObject);
}