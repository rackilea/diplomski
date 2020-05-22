public void addBook(Book book) {
    for (int i = 0; i < books.length; i++) {
        if (books[i] == null) {
            books[i] = book;
            return;
        }
    }
}