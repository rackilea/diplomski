List<String> r = list1
  .parallelStream()
  .filter( w1->{
      return list2
        .parallelStream()
        .anyMatch( w2->w1.contains(w2) ); 
      }
   )
  .collect(Collectors.toList());