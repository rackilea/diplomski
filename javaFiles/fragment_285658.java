Class<?> type = new ByteBuddy()
  .rebase(HelloWorld.class)
  .defineMethod("sayHelloAgain", void.class, Visibility.PUBLIC)
  .intercept(MethodDelegation.to(HelloAgainDelegate.class))
  .method(named("sayHelloWorld"))
  .intercept(SuperMethodCall.INSTANCE
    .andThen(MethodCall.invoke(named("sayHelloAgain"))))
  .make()
  .load(HelloWorld.class.getClassLoader(), 
        ClassLoadingStrategy.Default.CHILD_FIRST)
  .getLoaded();

Object instance = type.newInstance();
type.getMethod("sayHelloWorld").invoke(instance);
type.getMethod("sayHelloAgain").invoke(instance);