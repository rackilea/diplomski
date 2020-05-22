Map<String, String> myMap = new HashMap<String, String>();

for (int i = 1; i <= 13; i++) {  // Start loop from 1, as properties in txt file are from 1
    String abu = pro.getProperty("" + i);  

   // Split the string on space, and put 1st and 2nd element of array 
   // as `key-value` pair in HashMap
   String[] arr = abu.split(" ");
   myMap.put(arr[0], arr[1]);
}

// Now you can fetch the data
for (String str: myMap.keySet()) {
     System.out.println(myMap.get(str));
}