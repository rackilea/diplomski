for(Field f: clazz.getDeclaredFields()) {
    Type type = f.getGenericType();
    ParameterizedType impl = (ParameterizedType) type;
    Class genericArgument = (Class) impl.getActualTypeArguments()[0];
    System.out.println(genericArgument);
}