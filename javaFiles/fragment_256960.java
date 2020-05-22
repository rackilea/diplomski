public class SuperClass<T> {

  public T method1() {
    return (T) this;
  }

}

public class SubClass extends SuperClass<SubClass> {

  public SubClass method2() {
    return (SubClass) this;
  }

}