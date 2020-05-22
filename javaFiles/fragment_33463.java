Stream.concat(stream1, stream2)
      .collect(Collectors.toMap(Student::getNo, 
               Function.identity(), 
               (l, r) -> l, 
               LinkedHashMap::new)
      ).values();