String s1 = "";      // Hashcode = 0
String s2 = "\0";    // Hashcode = 0
String s3 = "\0\0";  // Hashcode = 0

HashMap<String, String> m = new HashMap<>();
m.put("one", s1);
m.put("one", s2); // This does not change m.hashCode() yet its content changes!