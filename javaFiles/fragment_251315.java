public class A {
    public B foo;
    public C bar;

    public A() {
      // java does not like exposing this, but screw that
      foo = new B(this, 10);
      C = new C(this);
    }
}

public class B {
    private A parent;
    public int numB;

    public B(A parent, int num) {
      this.parent = parent;

      numB = num;
    }
}

public class C {
    private A parent;
    public int numC;

    public C(A parent) {
      this.parent = parent;

      if(parent != null && parent.B != null)
        numC = parent.B.numB;
    }
}