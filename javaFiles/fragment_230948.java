Map<String, Deque<Integer>> map = new HashMap<>();
Deque<Integer> deque = new ArrayDeque<>(); // use Deque instead of Stack
map.put("abc", deque); // putting the Deque in Map
map.get("abc").add(12);
map.get("abc").add(34);
map.get("abc").add(56);
map.get("abc").add(78);

System.out.println("Before removing: " + map);
map.get("abc").remove(); // removing first element
System.out.println("After  removing: " + map);