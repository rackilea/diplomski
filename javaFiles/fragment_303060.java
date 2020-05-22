YourObject objectToAdd = ...
Map<String, YourObject> map = new HashMap<>();
...
YourObject objectInMap = map.get(objectName);
if(objectInMap != null) {
    // increase Quantity in objectInMap 
} else {
    //Object not existing in the map, never added
    //manage initial quantity here
    map.put(objectToAdd.getName(), objectToAdd)
}