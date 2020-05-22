@PostMapping("/books")
public RedirectView create(Book book) {
    Author author = authorService.findById(book.authorId);
    book.setAuthor(author);
    bookService.create(book);
    return new RedirectView("/books.html?isbn=" + book.getIsbn());
}