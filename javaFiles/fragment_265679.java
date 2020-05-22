class Class1<T<X extends Class3> extends Class2<X>, E extends Class3> {
    public E someFunction(T<E> param) {
        ...
    }
}

Class1<Class21, Class31> var = ...