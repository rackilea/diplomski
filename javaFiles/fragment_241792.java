Map<String, Map<String, Integer>> map = table.rowMap();

for (String row : map.keySet()) {
    Map<String, Integer> tmp = map.get(row);
    for (Map.Entry<String, Integer> pair : tmp.entrySet()) {
        System.out.println(row+" "+pair.getKey()+" "+pair.getValue());
    }
}