static class Super {
  {
    //called before any of the Super constructors
    System.out.println( "Super initializer" );
  }

  private final void init() {
    System.out.println( "Super init method" );
  }

  public Super() {
    System.out.println( "Super common constructor" );
  }

  public Super(String name) {
    this(); //needs to be the first statement if used
    System.out.println( "Super name constructor" );
    init(); //can be called anywhere
  }
}

static class Sub extends Super {
  {
    //called before any of the Sub constructors
    System.out.println( "Sub initializer" );
  }

  private final void init() {
    System.out.println( "Sub init method" );
  }

  public Sub() {
    System.out.println( "Sub common constructor" );
  }

  public Sub(String name) {
    super( name ); //needs to be the first statement if used, calls the corrsponding Super constructor
    System.out.println( "Sub name constructor" );
    init(); //can be called anywhere
  }
}