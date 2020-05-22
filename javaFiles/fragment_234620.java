Map<String,Animal> animals = 
    Stream.of(dogs.entrySet(), cats.entrySet(), elephants.entrySet())
          .flatMap(Set::stream)
          .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));

//Stream.of(dogs, cats, elephants).flatMap(m -> m.entrySet().stream()) could also be an option