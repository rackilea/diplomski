public static List<Book> getSortedByPositionWithoutSpaces(List<Book> books) {
    final AtomicLong i = new AtomicLong();
    List<Book> sortedList = books.stream()
            .map(e -> Book.of(e.getId(), e.getPosition()))
            .sorted(comparing(Book::getPosition))
            .map(e -> Book.of(e.getId(), i.getAndIncrement()))
            .collect(toList());        
    return sortedList;
}