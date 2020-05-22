Multimap<String, Object> myMultimap = ArrayListMultimap.create();

// fill it
myMultimap.put("hello", "hola");
myMultimap.put("hello", "buongiorno");
myMultimap.put("hello", "สวัสดี");

// retrieve
List<String> greetings = myMultimap.get("hello");
                      // ["hola", "buongiorno", "สวัสดี"]