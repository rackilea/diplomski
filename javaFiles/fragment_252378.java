Map<Long, Integer> m = new LinkedHashMap<>();
//fill your map here
List<Pair> l = new ArrayList<>();
for(Map.Entry<Long, Integer> entries : m.entrySet()){
    l.add(new Pair(entries.getKey(), entries.getValue()));
}
//Now you have a list of Pair