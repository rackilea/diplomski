class NullType {

  public static final void main(final String[] args) {
    foo();
  }

  static void foo()
  {
    Object testVal = null;
    foo(testVal);    // dispatched to foo(Object)
    foo(null);    // compilation problem -> "The method foo(String) is ambiguous"   
  }

  public static void foo(String arg) { // More-specific
    System.out.println("foo(String)");
  }

  public static void foo(Object arg) { // Generic
    System.out.println("foo(Object)");
  }

}