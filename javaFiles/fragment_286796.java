private final Class<T> clazz;
private Object myObj
public MyClass(Class<T> clazz, MyFactory myFactory) {
    this.clazz = clazz;
    this.myObj = myFactory.getByClass(clazz);
}