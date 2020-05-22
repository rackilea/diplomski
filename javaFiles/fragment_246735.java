@Override public void configure() {
  // BAD: To change the scope, you'll need to change three lines.
  // If you don't change all three together, you'll get inconsistent behavior.
  bind(A.class).to(AImpl.class).in(MyScope.INSTANCE);
  bind(B.class).to(BImpl.class).in(MyScope.INSTANCE);
  bindScope(AScoped.class, MyScope.INSTANCE);
}

@Override public void configure() {
  // GOOD: To change the scope, you can change one line, and optionally
  // extract that line to a separate Module.
  bind(A.class).to(AImpl.class).in(AScoped.class);
  bind(B.class).to(BImpl.class).in(AScoped.class);
  bindScope(AScoped.class, MyScope.INSTANCE);
}