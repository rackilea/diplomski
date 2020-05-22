boolean doesValueBelongToKey(Map map, Object key, Object value) {
    if(map.containsKey(key) && map.get(key).equals(value))
        return true;
    else
        return false;
}