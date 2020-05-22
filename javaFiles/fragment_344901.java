List<WordComparable> l = map.entrySet()
                            .stream() //make a Stream of our entries
                            .map(new Function<Map.Entry<String, Integer>, WordComparable>() {
                                 @Override
                                 public WordComparable apply(Map.Entry<String, Integer> entry) {
                                     return new WordComparable(entry.getKey(), entry.getValue());
                                 }
                             }) //let's convert each entry to a WordComparable
                             .collect(Collectors.toList()); //and make a List out of it