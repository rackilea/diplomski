@SuppressWarnings("unchecked")
  public static <T> T[] getArray(Class<T> clz, Object value) {
    Object array = Array.newInstance(clz, 1);
    Array.set(array, 0, value);
    return (T[]) array;
  }