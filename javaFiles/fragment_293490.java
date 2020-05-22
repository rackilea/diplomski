List<Integer> ids = new ArrayList<Integer>();
Map<Integer, MyObject> mapToInsert = new HashMap<Integer, MyObject>();
for(MyObject o in  objects) {
    //add the ids of the objects to possibly insert
    ids.add(o.getId());
    //using the id of the object as the key in the map
    mapToInsert.put(o.getId(), o);
}

//retrieve the ids of the elements that already exist in database
List<MyObjectRow> unwanted_objects = MyObject.find("id in (?,?,?,?,.....)",ids);

//remove the query results from the map, not the list
for(MyObjectRow o in unwanted_objects){
     mapToInsert.remove(o.getId());
}

//insert the values that still exist in mapToInsert
Collection<MyObject> valuesToInsert = mapToInsert.values();