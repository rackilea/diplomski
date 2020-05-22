public class XTransformerVisitor implements XVisitor {
  private X result;
  private A first;
  public void visit(A a) {
    if (first == null) first = a;
    else result = a;
  }
  public void visit(B b) {
    if (first == null) throw new RuntimeException();
    result = first;
  }
  public X transform(X x1, X x2) {
    x1.accept(this);
    x2.accept(this);
    return result;
  }
}