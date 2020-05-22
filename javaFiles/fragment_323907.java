Collection<Book> result = list.stream()
        .collect(Collectors.toMap(
                b -> Map.entry(b.getTitle(), b.getPages()),
                b -> new Book(b.getTitle(), b.getPages(), b.getList()),
                (b1, b2) -> new Book(b1.getTitle(), b1.getPages(),
                        Stream.concat(b1.getList().stream(), b2.getList().stream()).collect(Collectors.toList())),
                LinkedHashMap::new))
        .values();