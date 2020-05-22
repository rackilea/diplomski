public static Stream<Class<? extends CharSequence>> getClasses2 () {

return Arrays.asList ("java.lang.String", "java.lang.StringBuilder", "Kaboom!").stream ().map (x -> {
  try {
    Class<?> result = Class.forName (x);
     return (Class<? extends CharSequence>)( result == null ? null : result.asSubclass(CharSequence.class));
  } catch (Exception e) {
    // TODO Auto-generated catch block
    e.printStackTrace ();
  }

  return (Class<? extends CharSequence>)null;
}).filter(x -> x != null);