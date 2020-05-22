Map<String, Integer> result = new TreeMap<String, Integer>();
for (String x : text1) {
   if (!result.containsKey(x)) {
       result.put(x, 1);
   } else {
       Integer count = result.get(x);
       result.put(x, ++count);
   }
}