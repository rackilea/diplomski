class A {
  static final String classPath = getClassPath();

  static String getClassPath() {
    try {
      return ...;
    } catch (IOException e) {
      return defaultValue;
    }
  }
}