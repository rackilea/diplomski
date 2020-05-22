@Override
public void visitChildren(BidComponentVisitor visitor) {
  vistor.visitCategory(this);
  for (BidComponent child : children) {
    child.visitChidren(visitor);
  }
}