HashMap<String, Object> first = new HashMap<String, Object>();
HashMap<String, Object> second = new HashMap<String, Object>();

first.put("100", "hello");
first.put("101", "nice");
second.put("100", "hello");
second.put("102", "good");

first.putAll(second);
System.out.println(first);