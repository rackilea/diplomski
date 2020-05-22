ListenableFuture<MyClass> future = myExecutor.submit(myCallable);

final ListenableFuture<Foo> foo =
    Futures.transform(
        future,
        new Function<MyClass, Foo>() { ... },
        myCallbackExecutor);
final ListenableFuture<Bar> bar = ...;
final ListenableFuture<Baz> baz = ...;

ListenableFuture<?> allAvailable = Futures.allAsList(foo, bar, baz);
ListenableFuture<?> allSet = Futures.transform(
    allAvailable, 
    new Function<Object, Object>() {
      @Override
      public Object apply(Object ignored) {
        // Use getUnchecked, since we know they already succeeded:
        builder.setFoo(Futures.getUnchecked(foo));
        builder.setFoo(Futures.getUnchecked(bar));
        builder.setFoo(Futures.getUnchecked(baz));
        return null;
      }
    }
};