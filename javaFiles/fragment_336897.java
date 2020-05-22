public static Stream<Class<? extends CharSequence>> getClasses () {

return Arrays.asList ("java.lang.String", "java.lang.StringBuilder", "Kaboom!").stream ().map (x -> {
  try {
    Class<?> result = Class.forName (x);
    return result == null ? null : result.asSubclass(CharSequence.class);
  } catch (Exception e) {

    e.printStackTrace ();
  }

  return null;
}).filter(x -> x != null);