HashSet<Integer> hs = new HashSet<Integer>(list2.size());
for(Object2 o : list2) {
    hs.add(o.object1id);
}
//hs contains all the ids of list2
List<Object1> result = new ArrayList<Object1>(); //Or another class implementing List
for(Object1 o : list1) {
    if(hs.contains(o.id))
        result.add(o);
}