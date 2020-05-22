class A {
  int value;
  A(int value) { this.value = value; }
  int getValue() { return this.value; }
}

public void doSomething() {
  A a = new A(0);
  // no way to change a.value
}