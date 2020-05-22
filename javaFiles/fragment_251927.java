//These compile fine
boolean result1 = safeContainsKey(map, 12345l);
Object obj1 = safeGet(map, 12345l);

//These cause compilation errors
boolean result2 = safeContainsKey(map, "12345");
Object obj2 = safeGet(map, "12345");