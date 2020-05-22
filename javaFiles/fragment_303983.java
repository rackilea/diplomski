Comparator<Item> comp = Comparator.comparing(Item::getModificationDate, Comparator.reverseOrder());
List<Item> sorted = Stream.concat(list.stream()
                                      .filter(f -> "animal".equals(f.getType())), 
                                  list.stream()
                                      .filter(f -> !"animal".equals(f.getType()))
                                      .sorted(comp)
                                      .limit(1))
                             .sorted(comp)
                             .collect(Collectors.toList());

System.out.println(sorted);