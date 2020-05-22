HashMap<Integer, List<Object2>> hm = new HashMap<Integer, List<Object2>>();
for(Object2 o : list2) {
    List<Object2> l = hm.get(o.objectid1);
    if(l != null) {
        l.add(o);
    } else {
        List<Object2> l = new ArrayList<Object2>();
        l.add(o);
        hm.put(o.objectid1, l);
}
//hm is map, where each entry contains the list of Object2 associated with objectid1
List<Object1> result = new ArrayList<Object1>();
for(Object1 o : list1) {
    List<Object2> l = hm.get(o.id);
    //l contains all Object2 with object1id = o.id
    for(Object2 o2 : l)
        result.add(new Object3(o, o2));
}