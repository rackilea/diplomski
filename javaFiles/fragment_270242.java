// return the list if already present or make a new one, insert into the map 
// and return the newly created one
List<XXX> objectList = objectMap.computeIfAbsent(key, k -> new ArrayList<>());

// add new object to list
objectList.add(objectToAdd);