private final ThreadLocal<SimpleDateFormat> localFormat =
    new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(...);
        }
     };
...
// if a number of threads run this common code
SimpleDateFormat format = localFormat.get();
// now we are using the per-thread format (but we should be using Joda Time :-)
format.parse(...);