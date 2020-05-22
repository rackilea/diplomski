Class<? extends TargetClass> proxy = new ByteBuddy()
  .subclass(targetClass)
  .method(any())
  .intercept(MethodDelegation.to(MyInterceptor.class)
                             .andThen(SuperMethodCall.INSTANCE)
  .defineField("myCustomField", Object.class, Visibility.PUBLIC)
  .make()
  .load(targetClass.getClassLoader())
  .getLoaded();

class MyInterceptor {
  static void intercept(@FieldValue("myCustomField") Object myCustomField) {
    // do something
  }
}