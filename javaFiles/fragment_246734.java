@Override
protected void configure() {
  bindScope(RequestScoped.class, REQUEST);
  bindScope(SessionScoped.class, SESSION);
  // ...
}