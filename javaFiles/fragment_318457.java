//structure to store a map of key/value for a key
 Map<String, Map<String, Integer>> hashmap = new HashMap<String, Map<String, Integer>>(); 

   //key/value map
   Map<String, Integer> US = new HashMap<String, Integer>(); 
   US.put("X", 1200); 
   US.put("Y", 50); 
   US.put("Z", 25552); 
   //can add any number, doesn't have to be three

   Map<String, Integer> UK = new HashMap<String, Integer>(); 
   UK.put("X", 222); 
   UK.put("Y", 52); 
   UK.put("Z", 18);

   hashmap.put("USA", US); 
   hashmap.put("UK", UK);

   //loop through main keys (i.e. US, UK, Africa, etc.)         
   for (String key : hashmap.keySet()) {
       Map<String, Integer> temp = hashmap.get(key); 
        System.out.println("Calculating for " + key);
        Integer sum = 0; 
        //for each key i.e. UK loop through its properties
        for(String otherKey: temp.keySet()) {
            sum = sum + temp.get(otherKey); 
        }
      System.out.println("Sum for " + key + " is " + sum);
   }