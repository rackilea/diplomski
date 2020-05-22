InstanceTable t = new InstanceTable();
t.put(String.class, "foo");          // compiles
t.put(Integer.class, "bar")          // doesn't compile
String foo = t.get(String.class);    // compiles
Integer one = new Integer(1);
Integer bar = t.get(one.getClass()); // doesn't compile