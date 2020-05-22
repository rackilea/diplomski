// This list contains a list. That list has ONE TYPE. It can
// only store one kind of list.
// I cannot add a List<Role> to it.
List<List<?>> listOfListsOfUnknownTypes = new ArrayList<ArrayList<Integer>>();

// This list contains a list. That list has ONE TYPE. It can
// only store lists of OBJECTS.
// I cannot add a List<Role> to it. I cannot add a List<Integer> to it.
// I can only add List<Object> to it.
// I CAN add objects to the lists inside the list.
List<List<Object>> listOfListsOfObjects = new ArrayList<ArrayList<Object>>();

// Not sure if will compile okay actually
// This list contains unknown lists. All you know about them 
// is that they should be some kind of list. You don't know 
// what types of objects the list contains. Or even the type of 
// list. 
// BUT it is ONE type of list because you are using the CAPTURE '?'
List<? extends List<?>> listOfUnknownList = new ArrayList<ArrayList<Object>>();

// I think that what you want is this:
List<List<Object>> listOfUnknownList = new ArrayList<ArrayList<Object>>();