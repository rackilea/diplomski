public enum Foo {
  // Idiomatic Java names. You could ignore those if you really want,
  // and overload the constructor to have a parameterless one which calls
  // name() if you really want.
  FIRST("first"),
  SECOND("second"),
  WITH_SPACE("with space");

  private static final Map<String, Foo> nameToValueMap;

  static {
    // Really I'd use an immutable map from Guava...
    nameToValueMap = new HashMap<String, Foo>();
    for (Foo foo : EnumSet.allOf(Foo.class)) {
      nameToValueMap.put(foo.friendlyName, foo);
    }
  }

  private final String friendlyName;

  private Foo(String friendlyName) {
    this.friendlyName = friendlyName;
  }

  public String getFriendlyName() {
    return friendlyName;
  }

  public static Foo fromFriendlyName(String friendlyName) {
    return nameToValueMap.get(friendlyName);
  }
}