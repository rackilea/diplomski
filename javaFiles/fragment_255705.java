@SuppressWarnings("unchecked")
@RequestMapping( method = RequestMethod.GET )
public @ResponseBody List<Book> getBook() {
    List<Book> res = bookService.findAll();
    for(Book book : res) {
       book.getAuthor().setBooks(null);
    }
    return res;
}