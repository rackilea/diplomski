public final class ThreadLocal<T> {
   private final IdentityHashMap<Thread,T> valueMap;
   ...
   public T get() {
       return valueMap.get( Thread.currentThread() );
   }
}