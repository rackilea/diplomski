import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CacheMapImpl implements CacheMap<Integer, String> {

    private Map<Integer, Long> timesCache = new HashMap<Integer, Long>();
    private Map<Integer, String> values = new HashMap<Integer, String>();

    /** Time for the elemens to keep alive in the map in milliseconds. */
    long timeToLive = 0;

    @Override
    public void setTimeToLive(long timeToLive) {
        this.timeToLive = timeToLive;
    }

    @Override
    public long getTimeToLive() {

        return this.timeToLive;
    }

    @Override
    public String put(Integer key, String value) {
        values.put(key, value);
        timesCache.put(key, System.currentTimeMillis());
        return value;
    }

    @Override
    public void clearExpired() {

        // Just remove if timeToLive has been set before...
        if (timeToLive > 0) {
            List<Integer> keysToClear = new ArrayList<Integer>();
            long currentTime = System.currentTimeMillis();

            // Check what keys to remove
            for (Entry<Integer, Long> e : timesCache.entrySet()) {
                if ((currentTime - e.getValue().longValue()) > this.timeToLive) {
                    keysToClear.add(e.getKey());
                }
            }

            // Remove the expired keys
            for (Integer key : keysToClear) {
                this.timesCache.remove(key);
                this.values.remove(key);
            }
        }

    }

    @Override
    public void clear() {
        this.timesCache.clear();
        this.values.clear();
    }

    @Override
    public boolean containsKey(Object key) {

        return this.values.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {

        return this.values.containsValue(value);
    }

    @Override
    public String get(Object key) {

        return this.values.get(key);
    }

    @Override
    public boolean isEmpty() {

        return this.values.isEmpty();
    }

    @Override
    public String remove(Object key) {
        String rto = null;
        if (containsKey(key)) {
            this.values.remove(key);
            this.timesCache.remove(key);
            rto = key.toString();
        }
        return rto;
    }

    @Override
    public int size() {

        return this.values.size();
    }

}