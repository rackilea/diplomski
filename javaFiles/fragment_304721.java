public static final ThreadLocal<MyClass> VALUE = new ThreadLocal<MyClass>();
public void doSomething() {
  VALUE.set(this);
  try {
    doSomethingElse();
  } finally {
    VALUE.set(null);
  }
}