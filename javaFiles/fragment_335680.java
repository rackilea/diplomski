Map<Integer, String> myMap1 = new HashMap<Integer, String>();
PriorityQueue<Entry<Integer, String>> pq = new PriorityQueue<Map.Entry<Integer,String>>(myMap1.size(), new Comparator<Entry<Integer, String>>() {
    @Override
    public int compare(Entry<Integer, String> arg0, Entry<Integer, String> arg1) {
        return arg0.getValue().compareTo(arg1.getValue());
    }
});
pq.addAll(myMap1.entrySet());
while (!pq.isEmpty()) {
    System.out.println(pq.poll());
}