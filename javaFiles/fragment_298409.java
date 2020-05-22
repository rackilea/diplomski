class Parent {
  int i;
  public Parent(int i) {
    this.i=i;
  }
}

class Child extends Parent {
  int j;
  public Child(int i, int j) {
    super(i);
    this.j=j;
  }
  public Child(int j) {
    // here a call to super() is made, but since there is no no-arg constructor
    // for class Parent there will be a compile time error
    this.j=j;
  }
}