Map<Integer, Integer> map = new HashMap<>();
Integer x = 130;
Integer y = 130;
System.out.println(x == y); // False (on my machine)
map.put(x, 1000);
System.out.println(map.get(y)); // 1000