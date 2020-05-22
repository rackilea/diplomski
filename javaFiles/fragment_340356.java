public class MapConverter {
    public Map<String, String> convert(Map<String, Object> oldMap) {
        Map<String, String> ret = new HashMap<String, String>();
        for (String key : oldMap.keySet()) {
            ret.put(key, oldMap.get(key).toString());
        }
        return ret;
    }
}