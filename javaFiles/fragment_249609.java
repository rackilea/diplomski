public Collection<Book> getRecords() {
    return bookMap.values();
}

...

table.getRecords().stream()
   .filter(book -> book.getAuthor().equals("Charles Dickens"))
   .sorted(Comparator.comparing(Book::getTitle))
   .forEach(System.out::println);