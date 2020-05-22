ConcurrentHashMap<String, String> original = new ConcurrentHashMap<String, String>();
original.put("hello", "Salaam");

Map<String, String> copy = new ConcurrentHashMap<>(original);
original.remove("hello");
System.out.println(copy.get("hello"));