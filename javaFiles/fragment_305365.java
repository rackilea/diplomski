Queue queue = new PriorityQueue( map.size(), new MapComparable() );

queue.addAll( map.entrySet() );

LinkedHashMap<String, Long> linkedMap = new LinkedHashMap<String, Long>();

for (Map.Entry<String, Long> entry; (entry = queue.poll())!=null;) {
    linkedMap.put(entry.getKey(), entry.getValue());
}