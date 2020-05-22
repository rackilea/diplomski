public class MyHashMap<V> extends HashMap<String,V> {

    public Set<String> keysStartingWith(String s) {
        Set<String> result = new HashSet<String>();
        for(String key : keySet()) {
            if(key.startsWith(s)) {
                result.add(key);
            }
        }
        return result;
    }
}