public class ThreadGroupLocal<T> extends ThreadLocal<ValueHolder> {
     private static class ValueHolder {
         public Object value;
     }
     // Weak & Concurrent would be even the better, but Java API wont offer that :(
     private static ConcurrentMap<ThreadGroup, ValueHolder> map = new ConcurrentHashMap<ThreadGroup, ValueHolder>;
     private static ValueHolder valueHolderForThread(Thread t) {
         map.putIfAbsent(t.getThreadGroup(), new ValueHolder());
         return map.get(t.getThreadGroup());
     }
     @Override 
     protected ValueHolder initialValue() {
         return valueHolderForThread(Thread.currentThread());
     }
     public T getValue() { (T) get().value; }
     public void setValue(T value) { get().value = value; }
 }