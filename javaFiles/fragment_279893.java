public class FifoSet<T>
{
    private ConcurrentHashMap<T,T> _map;
    private ConcurrentLinkedQueue<T> _queue;

    public void add(T obj)
    {
       if (_map.put(obj,obj) != null)
          return;
       _queue.add(obj);
    }

    public T removeFirst()
    {
       T obj = _queue.remove();
       _map.remove(obj);
       return obj;
    }
}