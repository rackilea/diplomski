import java.util.HashMap;

public class InstrumentedHashMap<K> extends HashMap<K, Float> {

    private static final long serialVersionUID = 1L;
    private int MAX;

    public InstrumentedHashMap(int capacity) {
        super();
        MAX = capacity;
    }

    @Override
    public Float put(K key, Float value) {
        if (super.size() >= MAX && !super.containsKey(key)) {
            return null;
        } else {
            super.put(key, value);
            return value;
        }
    }

    public void event(K trigger, int multiplyAmount, float subtractAmount) {
        super.entrySet().stream().forEach(e -> {
            if (!e.getKey().equals(trigger))
                e.setValue(e.getValue() * multiplyAmount);
            else
                e.setValue(e.getValue() - subtractAmount);
        });
    }
}