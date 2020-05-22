class Container {
  public static class Container {
    Type1 obj1;
    Type2 obj2;
    ...
  }
  private Type1 obj1;
  private Type2 obj2;
  ...
  public Container getAllObjects() {
    Container container = new Container();
    container.obj1 = this.obj1;
    ...
    return container;
  }
}