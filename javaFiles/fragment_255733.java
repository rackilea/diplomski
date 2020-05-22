// consider m1 and m2 your two DefaultListModels:
DefaultListModel m1 = ... ;  
DefaultListModel m2 = ... ;

// retrieve the elements
List<?> elements1 = Arrays.asList(m1.toArray());
List<?> elements2 = Arrays.asList(m2.toArray());

// build the union set
Set<Object> unionSet = new HashSet<Object>();
unionSet.addAll(elements1);
unionSet.addAll(elements2);

// build the intersection and subtract it from the union
elements1.retainAll(elements2);
unionSet.removeAll(elements1);

// unionSet now holds the elements that are only present 
// in elements1 or elements2 (but not in both)