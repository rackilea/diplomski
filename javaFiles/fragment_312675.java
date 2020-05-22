@SuppressWarnings("unchecked")
public <E extends Enum<E>> E[] getValues(Class<E> clazz, String[] strings) {
  E[] result = (E[])java.lang.reflect.Array.newInstance(clazz, strings.length);
  for (int i = 0; i < strings.length; ++i) {
    result[i] = Enum.valueOf(clazz, strings[i]);
  }
  return result;
}