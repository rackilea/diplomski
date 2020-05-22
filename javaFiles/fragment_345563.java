@SuppressWarnings("unchecked")
  public static <T> T[] getArray(T value) {
    Object array = Array.newInstance(value.getClass(), 1);
    Array.set(array, 0, value);
    return (T[]) array;
  }