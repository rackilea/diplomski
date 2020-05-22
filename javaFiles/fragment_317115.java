MyHashMap<HashMap<String, Integer>> myHashMap = new MyHashMap<>();
HashMap<String, Integer> data;
for(String yearRangeKey : myHashMap.keysStartingWith("2014") {
   data = myHashMap.get(yearRangeKey);
   ...
}