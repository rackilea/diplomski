class ExposeInstrumentation {

  // public to assure accessability
  public static Instrumentation s_instrumentation;

  public static void premain(String arguments, Instrumentation inst) {
    s_instrumentation = inst;
  }

  public static Instrumentation getInstrumentation() {
    try {
      return (Instrumentation) ClassLoader.getSystemClassLoader()
          .loadClass(ExposeInstrumentation.class.getName())
          .getDeclaredField("s_instrumentation")
          .get(null);
    } catch(Exception e) {
      return null;
    }
  }
}