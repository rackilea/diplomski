public void foo(int[] bar) {
  bar = new int[]{9};
  System.out.println("Foo's bar: " + bar[0]);
}

public static void main(String[] args) {
  int[] bar = {5};
  new Foo().foo(bar);
  System.out.println("Main's bar: " + bar[0]);
}