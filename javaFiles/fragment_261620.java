Map<String,String> map = new IdentityHashMap<String,String>();
map.put("a", "1");
map.put("b", "2");
Iterator<Entry<String,String>> i = map.entrySet().iterator();
Entry<String,String> e1 = i.next();
System.out.println("first key is: " + e1.getKey());
Entry<String,String> e2 = i.next();
System.out.println("first key is now: " + e1.getKey());