@SuppressWarnings("unchecked")
static public <A, B extends A> Class<B> rawcast(Class<A> clazz)
{ 
    return (Class<B>)clazz; 
}

void test()
{
    Class<List<?>> clazz = rawcast(List.class);

    Something<List<?>> something2 = Something.create(clazz);
}