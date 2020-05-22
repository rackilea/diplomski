List<Book> r = list.stream().collect(
        Collectors.groupingBy(b -> Map.entry(b.getTitle(), b.getPages()), LinkedHashMap::new,
                Collectors.mapping(Book::getList, Collectors.toList())))
        .entrySet().stream()
        .map(e -> new Book(e.getKey().getKey(), e.getKey().getValue(), 
                e.getValue().stream().flatMap(Collection::stream).collect(Collectors.toList())))
        .collect(Collectors.toList());