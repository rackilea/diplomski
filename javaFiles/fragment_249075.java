class Factory<T extends Logic<?>, 
              U extends DAO<?>> 
{
    // Here, the generic method parameter only requires X
    // to be the same bound at method invocation. However,
    // you will "lose" that information again when the 
    // Factory is returned.
    public static <X extends Entity,
                   T extends Logic<X>, 
                   U extends DAO<X>> Factory<T, U> createFactory(T logic, U dao)
    {
        return new Factory<T, U>(logic, dao);
    }
}