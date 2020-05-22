class AuthorEntity {

  void add(BookEntity book) {

    this.books.add(book);

    if (!book.getAuthors().contains(this)) {
       book.add(this);
    }
  }
}