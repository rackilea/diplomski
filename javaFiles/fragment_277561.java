public Class<? extends Throwable> findMostSpecific(Class<? extends Throwable> type) {
     // we'll keep a reference to the most specific one here
     Class<? extends Throwable> mostSpecific = null;
     // here we iterate over your list of types
     for (Class<? extends Throwable> tType : list) {
         // well not even a subtype of tType so ignore it
         if (!tType.isAssignableFrom(type)) {
             continue;
         }

         if (mostSpecific == null || mostSpecific.isAssignableFrom(tType)) {
             mostSpecific = tType;
         }
     }
     return mostSpecific;
}