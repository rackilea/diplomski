// create the thing to store the sub lists
Map<Integer, List<MyObject>> subs = new HashMap<Integer, List<MyObject>>();

// iterate through your objects
for(MyObject o : list){

    // fetch the list for this object's id
    List<MyObject> temp = subs.get(o.getId());

    if(temp == null){
        // if the list is null we haven't seen an
        // object with this id before, so create 
        // a new list
        temp = new ArrayList<MyObject>();

        // and add it to the map
        subs.put(o.getId(), temp);
    }

    // whether we got the list from the map
    // or made a new one we need to add our
    // object.
    temp.add(o);
}