//create temp HashMap to check against
HashMap<Integer,String> mapkey = new HashMap<Integer,String>();
//populate it with the values to check for
mapkey.put(parentId,text);
if (unique_schemas.containsKey(mapkey)) {
    //do whatever when the entry exists
}