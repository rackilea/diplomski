public static Collection<WrapperFoo> wrapCollection0(Collection<Foo> src)
{
    try
    {
        Class<? extends Collection> clazz = src.getClass();
        Collection dst = clazz.newInstance();
        for (Foo foo : src)
        {
            dst.add(new WrapperFoo(foo));
        }
        return dst;
    } catch(Exception e)
    {
        e.printStackTrace();
        return null;
    }
}