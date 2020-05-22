DBObject obj = collection.findOne();
Set<String> keys = obj.keySet();
Iterator iterator = keys.iterator();

while(iterator.hasNext()){
  String key = iterator.next();
  Object value = obj.get(key);
  /* Do whatever you want */
}