private static Class<?> enumMapType(EnumMap<?, ?> map) {
  try {
    Field keyType = EnumMap.class.getDeclaredField("keyType");
    keyType.setAccessible(true);
    return (Class<?>) keyType.get(map);
  } catch (IllegalAccessException | NoSuchFieldException e) {
    throw new AssertionError("Could not find EnumMap type", e);
  }
}