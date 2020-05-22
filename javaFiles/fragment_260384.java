public static boolean empty(Object o) {
  return o == null;
}

public static boolean empty(Object[] array) {
  return array == null || array.length == 0;
}
public static boolean empty(int[] array) { //do the same for other primitives
  return array == null || array.length == 0;
}

public static boolean empty(String s) {
  return s == null || s.isEmpty();
}

public static boolean empty(Number n) {
  return n == null || n.doubleValue() == 0;
}

public static boolean empty(Collection<?> c) {
  return c == null || c.isEmpty();
}

public static boolean empty(Map<?, ?> m) {
  return m == null || m.isEmpty();
}