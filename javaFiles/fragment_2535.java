public HashMap<String, List<String>> generateFormatList() {
   HashMap<String, List<String>> formatList = new HashMap<String, List<String>>(); 

   for(String key : musiksammlung.keySet()) {
      // Value to store in map
      List<String> value = new ArrayList<String>();

      // Get the List<Music>
      List<Music> musicList = musiksammlung.get(key);
      for (Music m: musicList) {
          // Add String of each Music object to the List
          value.add(m.toString);
      }

      // Add the value to your new map
      formatList.put(key, value);  
   }
   // Return the new map
   return formatList;
}