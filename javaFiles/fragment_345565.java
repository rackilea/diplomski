@SuppressWarnings("unchecked")
  public static <T> T[] getArray(Class<T> clz, Object... values) {
    Object array = Array.newInstance(clz, values.length);
    System.arraycopy(values, 0, clz, 0, values.length);
    return (T[]) array;
  }