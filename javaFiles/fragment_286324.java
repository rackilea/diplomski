Map<Integer, Integer> dayValue = new HashMap<Integer, Integer>();
 for(Map<String, Integer> set : setData) {
     int day = set.get("day"); 
     int value = set.get("value");
     int storedValue = dayValue.get(day);
     // do your addition or subtraction with value and storedValue,
     // and update the map after that
     dayValue.put(day, storedValue);
 }