Map<Integer, Integer> myMap = new MyHashMap();

// printing result
System.out.println(myMap.put(10,20));   

// set result to a variable
boolean result = myMap.put(null,null);  // result = true

// or even setting and evaluating 
if (myMap.put(10,20)) {
   // success action
} else {
   // fail action
}