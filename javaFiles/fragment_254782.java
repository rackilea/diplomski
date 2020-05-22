HashMap<String, String> map = new HashMap<String, String>();
map.put("hello", "world");
map.put("lang", "en");

QueryString q = new QueryString(map);
System.out.println(q);
// => "hello=world&lang=en"