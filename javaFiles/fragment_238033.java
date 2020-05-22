Function<T,U> threadSafeReusableWrapper(Supplier<U> newWrapperInstanceFn, BiConsumer<U,T> wrapFn) {
   final ThreadLocal<T> wrapperStorage = ThreadLocal.withInitial(newWrapperInstanceFn);
   return item -> {
      T wrapper = wrapperStorage.get();
      wrapFn.consume(wrapper, item);
      return wrapper;
   }
}

Function<T,U> reusableWrapper(U wrapper, BiConsumer<U,T> wrapFn) {
   return item -> {
      wrapFn.consume(wrapper, item);
      return wrapper;
   };
}

list.stream()
    .map(reusableWrapper(new Wrapper(), Wrapper::setSource))
    .forEach( w -> processWrapper(w) );
list.stream()
    .map(threadSafeReusableWrapper(Wrapper::new, Wrapper::setSource))
     .parallel()
    .forEach( w -> processWrapper(w) );