Class<?> dynamicType = new ByteBuddy()
  .subclass(Class.forName(thatPeskyProprietaryClass))
  .namingStrategy(...)
  .method(ElementMatchers.named("someMethod"))
  .intercept(...)
  .make()
  .load(getClass().getClassLoader())
  .getLoaded();