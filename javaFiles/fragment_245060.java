@JsonAnySetter 
public void add(String key, String value) {
    map.put(key, value);
}

@JsonAnyGetter
public Map<String,String> getMap() {
    return map;
}