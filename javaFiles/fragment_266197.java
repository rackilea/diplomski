List<Map.Entry<String,Integer>> entries = new ArrayList<Map.Entry<String,Integer>>(
    freqMap.entrySet()
);
Collections.sort(
    entries
,   new Comparator<Map.Entry<String,Integer>>() {
        public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b) {
            return Integer.compare(b.getValue(), a.getValue());
        }
    }
);
for (Map.Entry<String,Integer> e : entries) {
    // This loop prints entries. You can use the same loop
    // to get the keys from entries, and add it to your target list.
    System.out.println(e.getKey()+":"+e.getValue());
}