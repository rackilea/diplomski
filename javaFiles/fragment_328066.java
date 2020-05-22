List<Book> books = list.stream()
                       .collect(Collectors.groupingBy(Book::getName))
                       .values()
                       .stream()
                       .map(book -> Collections.max(book, Comparator.comparingInt(Book::getCost)))
                       .collect(Collectors.toList());