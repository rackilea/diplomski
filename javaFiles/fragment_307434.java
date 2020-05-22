public void onPreUpdateCollection(PreCollectionUpdateEvent event) {
  PersistentCollection collection = event.getCollection();
  HashMap snapshot = (HashMap) collection.getStoredSnapshot();
  //set values are also stored as map values with same key and value as set value
  Set<Map.Entry> set = snapshot.entrySet();
  //Now this set contains key value of old collection values before update
}