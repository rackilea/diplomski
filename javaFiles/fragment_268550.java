class Library {
    private final Collection<Book> books = new ArrayList<Book>();

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Collection<Book> getAllBooks() {
        ...
    }

    public Book getBookByTitle(String title) {
        ...
    }
}