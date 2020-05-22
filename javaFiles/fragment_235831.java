class MyClass<T extends MyClass<T>> { 
  public T getParent() { ... }
  public List<T> getChildren() { ... }  // you can use an array here too, but don't :)
}

class MySubclass extends MyClass<MySubclass> {
  public String getId() { ... }
}