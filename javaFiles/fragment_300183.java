public static void setVersion(Object obj, int v) throws Exception {
  for (Method m : obj.getClass().getMethods()) {
    final Class<?>[] t = m.getParameterTypes();
    if (m.getName().equals("setVersion") && t.length == 1)
      m.invoke(obj, t[0] == String.class? String.valueOf(v) : v);
      break;
  }
}