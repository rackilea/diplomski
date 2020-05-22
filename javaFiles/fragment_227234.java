HashMap<String, Integer> occurrences = ...
TreeMap<Integer, String> map = new TreeMap<>();
int count = 0;
for (Map.Entry<String,Integer> entry : occurrences.entrySet()) {
    map.put (count, entry.getKey());
    count += entry.getValue();
}