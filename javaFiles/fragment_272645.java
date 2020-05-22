Map<String, List<String>> map = new HashMap<>();
...
List<String> values = map.get(attr);
if(values == null) {
    values = new ArrayList<String>();
    map.put(attr, values);
}
values.add("hai");