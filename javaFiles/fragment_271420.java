ArrayList<Number> numbers = new ArrayList<>();
nubers.add( 1.0 );

// cast the list<Number> to a list<Integer>
ArrayList<Integer> ints = (ArrayList<Integer>)numbers;
Integer x = ints.get(0);  // trouble here