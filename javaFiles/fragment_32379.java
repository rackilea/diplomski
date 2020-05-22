// For an array, 
 final Function<String[], String> firstArr =
    ((Function<Optional<String>,String>)Optional::get)
      .<Stream<String>>compose(Stream::findFirst)
      .compose(Arrays::stream);

 // For a collection
 final Function<List<String>, String> firstCol =
    ((Function<Optional<String>,String>)Optional::get)
      .<Stream<String>>compose(Stream::findFirst)
      .compose(Collection::stream);