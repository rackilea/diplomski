public OtherClass(Object obj)
{
    Class<?> clazz = obj.getClass();
    // do some stuff...

    // Call method from obj
    Method method = clazz.getMethod("callback", SomeObject.getClass());
    method.invoke(obj, SomeObject);
}