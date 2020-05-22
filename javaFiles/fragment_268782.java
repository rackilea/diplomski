Set<String> statesAsSet = new HashSet<String>();
 for (Person p : persons) {
     statesAsSet.add(p.getState());
 }

 // if yo want a list:
 List<String> statesAsList = new ArrayList<String>(statesAsSet);
 // if you want an array:
 String[] statesAsArray = statesAsSet.toArray(new String[statesAsSet.size()]);