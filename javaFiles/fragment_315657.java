interface IOConsumer<T> {
   void accept(T t) throws IOException;
}

static<T> Consumer<T> exceptionWrappingBlock(IOConsumer<T> b) {
   return e -> {
    try { b.accept(e); }
    catch (Exception ex) { throw new RuntimeException(ex); }
   };
}