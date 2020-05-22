Dog d1 = new Dog("clover");
Dog d2 = new Dog("clover");
t(d1 == d2);                   // false: different objects!
m.put(d1, "Dog key");          // put in with D1 object
System.out.println(m.get(d1)); // "Dog key"   -okay, equals
System.out.println(m.get(d2)); // "Dog key"   -okay, equals
d2.name = "arthur";            // *mutate* D2 object
t(d1.equals(d2));              // false: no longer equal
System.out.println(m.get(d1)); // "Dog key"   -okay, always equals, as per above
System.out.println(m.get(d2)); // ""          -no good, no longer equals