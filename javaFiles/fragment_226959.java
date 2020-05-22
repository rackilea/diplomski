public static Collection<String> contains(Map<String, String> map, List<String> list) {

   Collection<String> values = map.values();
   Set<String> result = new HashSet<String>();
   for (String listItem:list) {
     if (values.contains(listItem) {
       result.add(listItem);
     }
   }
   return result;  // contains a collection of all list items that are values of the map
}