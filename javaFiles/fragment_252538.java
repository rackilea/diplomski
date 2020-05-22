public Book getBookByTitleOrAuthor(String titleOrAuthor) {
    return books.stream()
                .filter(BookPredicate.matchTitleOrAuthor(titleOrAuthor))
                .filter(b -> {
                               final Book.bookStatus status = b.getBookStatus();
                               return status != null && 
                                      status != Book.bookStatus.Damaged && 
                                      status != Book.bookStatus.Deleted; 
                })  // can be moved into a BookPredicate method as well
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("There is no book for the given author or title."));
}