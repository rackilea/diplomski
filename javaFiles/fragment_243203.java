list3 = new ArrayList<>(
Stream.of(list1, list2)
  .flatMap(x -> IntStream.range(0,x.size()).mapToObj(index -> new SimpleEntry<>(index, x.get(index))))
  .collect(Collectors.collectingAndThen(
            Collectors.toMap(   SimpleEntry::getKey, 
                                SimpleEntry::getValue, 
                                (a, b) -> {return IntStream.range(0, a.size())
                                                    .mapToObj(index -> a.get(index) + b.get(index))
                                                    .collect(Collectors.toList());})
          , Map::values)));