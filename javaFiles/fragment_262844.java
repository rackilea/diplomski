List<MyObject> l = Collections.unmodifiableList(myList);
l.get(0);             // valid as long as element exists
l.get(0).foo();       // valid
l.get(0).setFoo(bar); // valid
l.remove(foo);        // INVALID
l.add(foo);           // INVALID