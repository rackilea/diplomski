public class HeapPriorityQueue<K,V> {

  protected ArrayList<Entry<K,V>> heap;
  protected TreeMap<Entry<K,V>, Integer> index;
  protected Comparator<K> comp;

  public synchronized void addEntry(K key, V value) {
    // requires O(log(n))
    Entry<K, V> entry = new Entry<K, V>(key, value);
    int insertionPos = heap.size();
    heap.add(entry);
    index.put(entry, insertionPos);
  }

  public int indexOfEntry(Entry<K,V> entry ) {
    // requires O(log(n))
    return index.get(entry);
  }

  protected static class MyEntry<K,V> implements Entry<K,V> {
    protected K key;
    protected V value;
    public MyEntry(K k, V v) {key = k; value = v;}
    public K getKey() {return key;}
    public V getValue() {return value;}
    public String toString() {return "(" + key + "," + value + ")";}
  }
}