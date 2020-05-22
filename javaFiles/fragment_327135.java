public <T> T specialClone( T obj, Class<T> type ) {
    T result = type.newInstance();
    Class<?> current = type;
    while( current != null ) {
        BeanInfo info = Introspector.getBeanInfo( current );
        for( PropertyDescriptor pd: info.getPropertyDescriptors() ) {
            Object value = pd.getReadMethod().invoke( obj );
            pd.getWriteMethod().invoke( result, value );
        }
        current = current.getSuperClass();
    }
    return result;
}