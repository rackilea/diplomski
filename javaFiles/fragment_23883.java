interface ResultSet<T> {
    Iterable<T> asIterable();
    // ... other methods ...
 }

 interface KeyOrError {
    boolean isError();
    boolean isKey();
    Key getKey();
    Throwable getError();
 }

 interface Status {
   boolean isOk();
   boolean isError();
   Throwable getError();
   void verifyOk();
 }