private static interface Foo {
  public void doFoo();
}

public static Foo a = new Foo() {
  public void doFoo() {
    // Do 'a' stuff here.
  }
}

public static Foo b = new Foo() {
  public void doFoo() {
    // Do 'b' stuff here.
  }
}

...

public static Foo e = new Foo() {
  public void doFoo() {
    // Do 'e' stuff here.
  }
}

public static void main(String[] arg){
  ArrayList<Foo> lst = new ArrayList<Foo>();
  lst.add(1, a);
  lst.add(2, b);
  lst.add(3, c);
  lst.add(4, d);
  lst.add(5, e);
}