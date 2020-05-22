//class is a reserved keyword so I call it clazz instead.
public MyClass(Class<T> clazz) {
  this.clazz = clazz;
}

public Class<T> getType() {
  return this.clazz;
}