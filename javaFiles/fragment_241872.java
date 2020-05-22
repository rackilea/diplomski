// Assuming 'field' refers to 'intItems' above
ResolvableType t1 = ResolvableType.forField(field); // List<Item<Integer>> 
ResolvableType t2 = t1.getGeneric(); // Item<Integer>
ResolvableType t3 = t2.getGeneric(); // Integer
Class<?> c = t3.resolve(); // Integer.class

// or more succinctly
Class<?> c = ResolvableType.forField(field).resolveGeneric(0, 0);