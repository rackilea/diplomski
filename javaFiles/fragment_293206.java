class Foo {
  static Map<Integer, String> PRIORITY_LABELS = new HashMap<>();

  static {
    PRIORITY_LABELS.put(2, "VERBOSE");
    PRIORITY_LABELS.put(3, "DEBUG");
    PRIORITY_LABELS.put(4, "INFO");
    PRIORITY_LABELS.put(5, "WARN");
    PRIORITY_LABELS.put(6, "ERROR");
  }

  // rest of class goes here
}