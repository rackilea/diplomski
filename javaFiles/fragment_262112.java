private String findUniqueKey(Map<String, ?> map, String prefix)
{
   if (!map.containsKey(prefix))
      return prefix;
   int i = 1;
   while(true) { // or check i against a maximum
      String candidate = prefix + i;
      if (!map.containsKey(candidate))
         return candidate;
      i++;
   }
}