@Override
public void visitChildren(BidComponentVisitor visitor) {
  vistor.enterCategory(this);
  for (BidComponent child : children) {
    child.visitChidren(visitor);
  }
  vistor.exitCategory(this);
}