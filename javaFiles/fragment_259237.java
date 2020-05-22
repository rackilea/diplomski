List<String> getTransitiveKey(String key) {
   List<String> result = new LinkedList<String>();
   while(map.containsKey(key)) {
    // avoid endless loops
    if(result.contains(key)) {
      break;
    }

    result.add(key);  
    key = map.get(key)
  }
  return result;
}