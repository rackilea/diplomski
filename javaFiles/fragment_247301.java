private final Parser<T> parser; 

public ProtoDeserializer() {
    Class<?> subclass = this.getClass();

    try {
        ParameterizedType pType = (ParameterizedType) subclass.getGenericSuperclass();
        Class<T> tClass = (Class<T>) pType.getActualTypeArguments()[0];
        // In the case where the constructor for `T` takes no arguments.
        parser = tClass.newInstance().getParserForType();
    } catch(Throwable t) {
        throw new RuntimeException("Subclass not compatible", t);
    }
}