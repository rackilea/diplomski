Map<YourKey, YourValue> newMap = new HashMap<>(); //the implementation doesn't really matter for this one
for(Map.EntrySet<YourKey, YourValue> entrySet : currentMap.entrySet()) {
      if (...) {
          YourValue newValue = ...;
          //compute the newValue data
          //...
          newMap.put(entrySet.getKey(), newValue); 
      }
}
for (Map.EntrySet<YourKey, YourValue> entrySet : newMap.entrySet()) {
    currentMap.put(entrySet.getKey(), entrySet.getValue());
}