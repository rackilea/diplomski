public static interface Foo extends Serializable, Comparable<Object> {
}

public static void main(String[] args) {
  // Problem: Unsafe: varargs has generic type
  implicitList("1", 2, BigDecimal.valueOf(3.5)); // warning: generic vararg

  // Solution 1: Constrain type of varags explicitly through generics
  explicitList1(Object.class, "1", 2, BigDecimal.valueOf(3.5));
  // However, we could still have the same error from problem
  explicitList1(Foo.class, "1", 2, BigDecimal.valueOf(3.5)); // warning: generic vararg
  // Fix: Make containing class to exact type (PECS) an array is both producer and consumer
  explicitList2(Foo.class, "1", 2, BigDecimal.valueOf(3.5)); // error: incompatible args

  // Solution 2: Override varargs by passing array
  implicitList(new Object[] { "1", 2, BigDecimal.valueOf(3.5) });
}

private static <T> List<T> explicitList1(Class<? extends T> klass, T... items) {
  return Arrays.asList(items);
}

private static <T> List<T> explicitList2(Class<T> klass, T... items) {
  return Arrays.asList(items);
}

private static <T> List<T> implicitList(T... items) {
  return Arrays.asList(items);
}