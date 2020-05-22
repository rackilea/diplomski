Ordering.natural() // the natural ordering on integers
  .onResultOf(
     Functions.forMap(map) // use the Map<String, Integer> as a Function
     // this ordering now compares Strings by the natural ordering of
     // the integers they're mapped to
  .reverse(); // reverses the ordering, so it now sorts in descending order