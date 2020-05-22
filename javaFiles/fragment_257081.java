else if(line.contains("Result:")){
    // check if the key exists in the map, or if the value is null
    if( !hmap1.get(Id).containsKey(relation) || hmap1.get(Id).get(relation) == null ) {
        rel = new ArrayList<>(); // make new list
    }
    // otherwise, get the list from your map
    else {
        rel = hmap1.get(Id).get(relation); // get the result list
    }
    // add result to the list
    rel.add(line); 
    // add the list to the map...
    hmap1.get(Id).put(relation, rel);
}