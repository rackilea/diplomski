Map<String, Integer> map; // populated
List<Map.Entry<String, Integer>> entries = new ArrayList<> (map.entrySet());
Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
    public int compareTo(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        return a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : Integer.compareTo(b.getValue(), a.getValue());
    }
});
for (Map.Entry<String, Integer> entry : entries)
    System.out.println(entry.getKey() + " - " + entry.getValue());