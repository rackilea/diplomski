class Foo {
  static {
    System.out.println("static initializer");
    System.out.println("class Foo now initialized");
  }

  {
    System.out.println("instance initializer");
    System.out.println("an instance of Foo has been created");
  }
}