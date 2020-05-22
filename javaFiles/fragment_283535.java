public static void removeObject(Map<Integer, String> map, String value) {
   for (Map.Entry<Integer, String> entry : map) {
       if (entry.getValue().equals(value) ) {
           map.remove(entry.getKey());
       }
   }
}