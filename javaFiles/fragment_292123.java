class MyObject {
  // Multiple @AssistedInject constructors, selected based on which parameters
  // are marked with @Assisted.

  @AssistedInject public MyObject(@Assisted FirstDep first,
       SecondFactory secondFactory, ThirdDep third) {
    this(first, secondFactory.createSecond(first), third);
  }

  @AssistedInject public MyObject(@Assisted FirstDep first,
      @Assisted SecondDep second, ThirdDep third) { /**/ }
}

interface SecondFactory {
  // Note that @Assisted annotations are not needed here. Every parameter in
  // these interfaces is for assisted injection, by definition.
  SecondDep createSecond(FirstDep first);
}

interface MyObjectFactory {
  MyObject createMyObject(FirstDep first);
  MyObject createMyObject(FirstDep first, SecondDep second);
}