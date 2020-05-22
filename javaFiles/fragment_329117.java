// variant A

class B extends A {
  B (int a, int c) {
    super(a, c);
  }
}

// variant B

class B extends A {
  B () {
    super(0, 0); // replace 0 with an appropiate default value for each parameter
  }
}