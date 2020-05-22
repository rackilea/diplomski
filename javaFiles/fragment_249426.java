Iterator<?> i = parents.keySet().iterator();
// Alternative, if you don't need the name of the key of the parent node:
// Iterator<?> i = parents.values().iterator();
while(i.hasNext()) {
    String parentKey = (String) i.next();
    JSONArray p = (JSONArray) parents.get(parentKey);
    System.out.println(parentKey);

    // If you don't need the name of the parent key node, 
    // replace the above with:
    // JSONArray p = (JSONArray) i.next();
    // Remember to use the alternative iterator-definition above as well

    for(Object o : p) {
        JSONObject child = (JSONObject) o;
        System.out.println("\t" + child.keySet() + ": " + child.values());
    }
}