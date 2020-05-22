Map<String, SomeClass> map = new HashMap<>(); // map from parent name to SomeClass
map.put("Test1", new SomeClass("Test1", "none"));
map.put("Test2", new SomeClass("Test2", "none"));
map.put("Test1Mem1", new SomeClass("Test1Mem1", "Test1"));
map.put("Test2Mem1", new SomeClass("Test2Mem1", "Test2"));
map.put("Test1Mem1Obj1", new SomeClass("Test1Mem1Obj1", "Test1Mem1"));