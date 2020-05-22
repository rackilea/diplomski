Map<Author, Set<BookType>> authorListBookType = books.stream()
    .flatMap(book -> book.getAuthors().stream()
            .map(author -> Map.entry(author, book.getType())))
    .collect(Collectors.groupingBy(
            Map.Entry::getKey,
            Collectors.mapping(
                    Map.Entry::getValue,
                    Collectors.toSet())));