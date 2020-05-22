public void addBook(Book book) {
    for (int i = 0; i < books.length; i++) {
        if (books[i] == null) {
            books[i] = book;
            return;
        }
    }
    books = Arrays.copyOf(books, books.length + 1);
    books[books.length - 1] = book;
}