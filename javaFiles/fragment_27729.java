Map<String, Double> resultSet = 
           books.stream()
                .flatMap(book -> book.getAuthors()
                                     .stream()
                       .map(author -> new AbstractMap.SimpleEntry<>(author, book)))
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey,
                        TreeMap::new,
                        Collectors.averagingDouble(e -> e.getValue().getRating())));