public abstract class Parent<T extends Parent<T>> {
  protected abstract T newInstance();

  public T doSomething() {
    T instance = newInstance();
    // do something with instance
    return instance;
  }

  public T doSomethingElse() {
    // do something with this
    return this;
  }
}

public class Child extends Parent<Child> {
  protected Child newInstance() {
    return new Child();
  }
}