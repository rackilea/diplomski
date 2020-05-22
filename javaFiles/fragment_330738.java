ArrayList<Map.Entry<String,Integer>> arraylist = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
Collections.sort(arraylist, new Comparator<Map.Entry<String,Integer>>() {
    @Override
    public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
        // Compares by count in descending order
        return e2.getValue() - e1.getValue();
    }
});

// Outputs the list in reverse alphabetical (or descending) order, case sensitive

for (Map.Entry<String,Integer> entry : arraylist) {
    System.out.println(entry.getKey() + " --> " + entry.getValue());
}