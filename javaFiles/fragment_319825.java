Map<Integer, String> map = new TreeMap<Integer, String>();

// Add Items to the TreeMap
map.put(1, "One");
map.put(2, "Two");
map.put(3, "Three");

// Iterate over them
for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " => " + entry.getValue());
}