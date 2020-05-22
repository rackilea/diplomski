//Populate the map
Map<String, Integer> map = new HashMap<>();
map.put("Hi", 4);
map.put("kumar", 1);
map.put("Hello", 1);
map.put("vivek", 3);

//Sort the values
List<Integer> values = new ArrayList<Integer>(map.values());
Collections.sort(values);

int size = values.size();
Set<Entry<String, Integer>> entries = map.entrySet();

//Create a new ordered map
ListOrderedMap<String, Integer> orderedMap;
orderedMap = ListOrderedMap.listOrderedMap(new HashMap<String, Integer>(map));

for (int i = 0; i < size; i++) {

    Integer value = values.get(i);
    Iterator<Entry<String, Integer>> iter = entries.iterator();

    while (iter.hasNext()) {
        Entry<String, Integer> entry = iter.next();
        if (value.equals(entry.getValue())) {
            //Put all values at index i that match the value
            orderedMap.put(i, entry.getKey(), value);
        }
    }
}

//Print the orderedMap key/value pairs
entries = orderedMap.entrySet();
for (Entry<String, Integer> entry : entries) {
    final String key = entry.getKey();
    final Integer value = entry.getValue();
    System.out.println("key = " + key + ", value = " + value);
}