public static void method() throws IOException {
  try {
    throwingMethod();
  } catch (Throwable t) { throw t; }
}

static void throwingMethod() throws IOException {}