// Encapsulate the createMyObject(first) shorthand.
class MyObjectHelper {
  @Inject MyObjectFactory rawFactory;

  MyObject createMyObject(FirstDep first) {
    return rawFactory.createMyObject(first, rawFactory.createSecond(first));
  }
}