// create the map to store stuff, note I'm using a List instead of an array
// in my opinion it's a bit cleaner
Map<String, List<Document>> map = new HashMap<String, List<Document>>();

// now iterate through each document
for(Document d : documents){

    // check to see if this type is already known
    List<Document> list = map.get(d.type);

    if(list == null){
        // list is null when it wasn't found in the map
        // this is a new type, create a new list
        list = new ArrayList<Document>();

        // store the list in the map
        map.put(d.type, list);
    }

    // finally, whether we got a hit or a miss, we want
    // to add this document to the list for this type
    list.add(d);
}