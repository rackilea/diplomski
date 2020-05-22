new ByteBuddy()
  .subclass(person.getClass())
  .method(isAnnotatedWith(MyFormat.class))
  .intercept(MethodDelegation.to(MyFormatInterceptor.class))
  .make()
  .load(person.getClass().getClassLoader(),                  
        ClassLoadingStrategy.Default.WRAPPER)
  .getLoaded();