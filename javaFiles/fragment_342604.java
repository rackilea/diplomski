@JsonCreator
public Pair(Map<String,String> json)
{
   Map.Entry<String,String> en = json.entrySet().iterator().next();
   key = en.getKey();
   value = en.getValue();
}

@JsonValue
public Map<String,String> asMap() {
  Map<String,String> m = new HashMap<String,String>();
  m.put(key, value);
  return m;
}