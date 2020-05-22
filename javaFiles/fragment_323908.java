List<Book> result = list.stream().collect(
        Collectors.groupingBy(b -> Map.entry(b.getTitle(), b.getPages()), LinkedHashMap::new,
                Collectors.flatMapping(b -> b.getList().stream(), Collectors.toList())))
        .entrySet().stream()
        .map(e -> new Book(e.getKey().getKey(), e.getKey().getValue(), e.getValue()))
        .collect(Collectors.toList());