Type type = bar.getClass().getGenericInterfaces()[0];

if (type instanceof ParameterizedType) {
    Type actualType = ((ParameterizedType) type).getActualTypeArguments()[0];
    System.out.println(actualType);
}