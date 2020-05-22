public class MyFoo implements Foo {
  @Inject Provider<MyBar> myBarProvider;

  Bar doSomething() {
    return myBarProvider.get(); // returns a new instance of MyBar
  }
}