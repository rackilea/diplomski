public class YourMap<K, V> extends HashMap<K, V> {

    private int state = 0;

    public YourMap() {
        super();
    }

    @Override
    public V put(K key, V value) {
        state++;
        return super.put(key, value);
    }

    public boolean isUpdated(int state) {
        return (state < this.state);
    }

    public int getState() {
        return state;
    }
    ... // Do the same with clear, remove... methods.
}