Map<String, List<Double<String, String>>> myMap =  
listOfTriples
.stream()
.collect(
  groupingBy(t -> t.a, 
    mapping((Triple<String, String, String> t) -> new Double<>(t.b, t.c), toList())
));