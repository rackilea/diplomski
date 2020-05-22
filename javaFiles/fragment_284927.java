for (Map.Entry<Integer, String> htEntries : map.entrySet()) {
    if(map2.containsKey(htEntries.getKey()) {
      join.put( htEntries.getKey(), htEntries.getValue());
      if (map2.get(htEntries.getKey()).equals(htEntries.getValue())) {
        inter.put(htEntries.getKey(), htEntries.getValue());
      } 
    } else {
       diff.put( htEntries.getKey(), htEntries.getValue());
    }
}

for (Map.Entry<Integer, String> diffEntries2 : map2.entrySet()) {
    if(!map.containsKey(diffEntries2.getKey())){
        diff2.put(diffEntries2.getKey(), diffEntries2.getValue());
    }
}