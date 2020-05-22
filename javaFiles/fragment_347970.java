List<Foo> foos = 
    itemsList.stream()
             .map(item -> new Foo(0L, item.getId(), item.getItems()
                                                        .stream()
                                                        .map(i -> new Bar(i.getId(), i.getName()))
                                                        .collect(Collectors.toList())))
             .collect(Collectors.toList());