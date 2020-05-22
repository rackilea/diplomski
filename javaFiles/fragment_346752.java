public class ModelImpl implement IRead {
  @Override
  public Foo getFoo() {...}

  private void setFoo(Foo f) {...}

  public void accept(Visitor v) {
    v.visit(new ModelEditor());
  }

  private class ModelEditor implement IWrite {
    @Override
    public void setFoo(Foo f) {
      ModelImpl.this.setFoo(f);
    }
  }
}