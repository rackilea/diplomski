/**
 * deeply clones a Map by cloning all the values.
 */
public Map<String,C> deepCopy(Map<String, C> original) {
    Map<String, C> copy = new HashMap<String, C>(original.size());
    for(Map.Entry<String, C> entry : original.entries()) {
        copy.put(entry.getKey(), entry.getValue().clone());
    }
}