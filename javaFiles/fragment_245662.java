HashSet<HashMap<String, List<HashMap<String, HashMap<String, String>>>>> fooSet = //;
String string1 = "string1";
String string2 = "string2";
HashMap<String, String> mapFound;


mapFound = fooSet.stream()                       // iterate over HashSet
       .filter(map -> map.containsKey(string1))  // keep maps that contains string1
       .findFirst()                              // take first map that match
       .orElseGet(HashMap::new)                  // take it really (or create new Map)
       .getOrDefault(string1, new ArrayList<>()) // take the List associated as value,or new List if not exists
       .stream()                                 // iterate over the list
       .filter(map -> map.containsKey(string2))  // keep maps that contains string2
       .findFirst()                              // take first map that match
       .orElseGet(HashMap::new)                  // take it really (or create new Map)
       .getOrDefault(string2, new HashMap<>());  // take HashMap associated as value, or new Map if not found