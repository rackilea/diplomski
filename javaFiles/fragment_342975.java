public void acceptInjectionVisitor(InjectionVisitor visitor) {
  visitor.needsInjection(this);
  visitor.makeInjectable(Key.get(FooContainer.class), this);
  for (InjectionVisitable child : children) {
    child.acceptInjectionVisitor(visitor);
  }
}