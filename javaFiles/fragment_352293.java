Map<String,Vector<String>> map = new HashMap... // etc
Vector<String> vec = new Vector<String>();
vec.addElement("foo");
map.put("foo",vec);
vec.clear();
vec.addElement("bar");
map.put("bar",vec);

Vector<String> ret = map.get("foo");
System.out.println(ret.get(0)); // prints bar