class Test {
  int i;
  void method() {
    System.out.print(i); // <-- Java compiler knows to look for the `i` on the class instance (technically it first looks for `i` locally in the scope of `method` and the goes to look on the class)
  }
}