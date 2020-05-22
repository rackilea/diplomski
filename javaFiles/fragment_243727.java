void foo(List<Number> list) {
   /// all lists have to have a 42
   list.add(new Integer("42"));
}

// later
List<Double> list = new ArrayList<>();
// oh man, we need to foo this list!
foo(list); // kaboom! when we add the integer to the double list!!