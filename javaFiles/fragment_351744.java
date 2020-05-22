private Map<String, MySymbol> symbolMap;

@JsonAnySetter
public void add(String key, MySymbol value) {
    symbolMap.put(key, value);
}