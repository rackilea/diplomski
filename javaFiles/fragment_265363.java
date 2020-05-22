List<String> list = ...;
Map<String, List<String>> map = 
  list.stream()
      .collect(Collectors.toMap(a -> a, a -> list.stream()
                                                 .filter(b -> P(a,b))
                                                 .collect(Collectors.toList()))
               );