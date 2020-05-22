List<Item> finalItems = groupedItems.entrySet().stream().map(entry -> 
               new Item(entry.getKey().name, 
                        entry.getKey().parentName,
                        entry.getValue().stream().mapToInt(
                                  item -> item.someValue).sum(),
                        entry.getValue().stream().mapToDouble(
                                  item -> item.anotherValue).sum()))
               .collect(Collectors.toList());