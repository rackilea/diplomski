public <T> T[] toArray(List<T> list, T[] a) {
  if (a.length < list.size()) {
    a = (T[])java.lang.reflect.Array.newInstance(
        a.getClass().getComponentType(), list.size()));
  }
  return list.toArray(a);
}