Dog d1 = new Dog("clover");
m.put(d1, "Dog key");          // put in with D1 object, hashCode = 6
System.out.println(m.get(d1)); // "Dog key" -okay, hashCode = 6, equals
d1.name = "Magnolia";          // change value such that it changes hash code
System.out.println(m.get(d1)); // ""        -fail, hashCode = 8, equals
// ^-- attaching a debugger will show d1.equals is not called