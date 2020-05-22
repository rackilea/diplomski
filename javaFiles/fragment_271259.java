public interface X {
  void accept(XVisitor v);
}

public interface XVisitor { 
  void visit(A a);
  void visit(B b);
}

public class A implements X {
  public void accept(XVisitor v) {
    v.visit(this);
  }
}

public class B implements X {
  public void accept(XVisitor v) {
    v.visit(this);
  }
}