public void foo(int bar) {
  bar += 4;
  System.out.println("Foo's bar: " + bar);
}

public static void main(String[] args) {
  int bar = 5;
  new Foo().foo(bar);
  System.out.println("Main's bar: " + bar);
}