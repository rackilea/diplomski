public static Stream<Class<? extends CharSequence>> getClasses() {
Stream<Class<? extends CharSequence>> map1 = Arrays.asList ("java.lang.String", "java.lang.StringBuilder", "Kaboom!").stream ().map (x -> {
  try {
    Class<?> result = Class.forName (x);
    return result == null ? null : result.asSubclass(CharSequence.class);
  } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace ();
  }

  return null;
});
return map1.filter(x -> x != null);