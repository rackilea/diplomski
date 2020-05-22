Map<Integer, String> map = new TreeMap<Integer, String>();
map.put(1, "one");
map.put(3, "three");
map.put(2, "two"); 
// prints one two three   
for(Integer key : map.keySet()) {
    System.out.println(map.get(key));
}