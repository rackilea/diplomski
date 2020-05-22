// Key contains ("2", "100", "1", ...)
// Value contains ("two", "four", "five", ...)
SortedMap<String, String> result = new TreeMap<String, String>();

// assuming the same size for both lists
for (int i = 0; i < Key.size(); i++) {
    // when adding to TreeMap, keys are ordered automatically
    result.put(Value.get(i), Key.get(i));
}

List<String> orderedKey = new ArrayList<String>(result.keySet());
List<String> orderedValue = new ArrayList<String>(result.values());