Iterator<Map.Entry<Integer, Integer>> entryItr = map.entrySet().iterator();
 while (entryItr.hasNext()) {
   Map.Entry<Integer, Integer> entry = entryItr.next();
   if (entry.getValue() > 1) {
     entry.setValue(entry.getValue() - 1);
   } else {
     entryItr.remove();
   }
 }