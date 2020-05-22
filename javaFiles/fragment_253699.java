new ByteBuddy().subclass(Date.class)
  .method(named("toString"))
  .intercept(FixedValue.value("Hello world!"))
  .make()
  .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
  .getLoaded()
  .newInstance();