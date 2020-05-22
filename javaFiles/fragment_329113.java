public static <T> T[] convert(
    Object[] array, Function<Object, Object> mapper, Class<T[]> returnClass) {

    Class componentType = returnClass.getComponentType();
    return Arrays.stream(array)
                 .map(array instanceof Object[][]?
                      r -> convert((Object[])r, mapper, componentType): mapper::apply)
                 .toArray(i -> returnClass.cast(Array.newInstance(componentType, i)));
}