private static final Map<Class<?>>, Class<?>> PRIMITIVE_TYPE_MAP =
    buildPrimitiveTypeMap();

private static Map<Class<?>>, Class<?>> buildPrimitiveTypeMap()
{
    Map<Class<?>>, Class<?>> map = new HashMap<Class<?>>, Class<?>>();
    map.put(float.class, Float.class);
    map.put(double.class, Double.class);
    // etc
    return map;
}