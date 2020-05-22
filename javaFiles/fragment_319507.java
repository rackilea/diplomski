// Get the value collection from the old HashMap
Collection<String> valueCollection = col.values();
Iterator<String> valueIterator = valueCollection.iterator();
HashMap<String, String> col1 = new HashMap<String, String>();
while(valueIterator.hasNext()){
     String currentValue = valueIterator.next();
     // Find the value in old HashMap
     Iterator<String> keyIterator = col.keySet().iterator();
     while(keyIterator.hasNext()){
          String currentKey = keyIterator.next();
          if (col.get(currentKey).equals(currentValue)){
               // When found, put the value and key combination in new HashMap
               col1.put(currentValue, currentKey);
               break;
          }
     }
}