String result = numbers.stream()
    .map(Object::toString)
    // or
    //   .map(x -> x.toString())  // exactly the same
    // or
    //   .map(String::valueOf)    // handles nulls by turning them to the string "null"
    .collect(Collectors.joining(","));