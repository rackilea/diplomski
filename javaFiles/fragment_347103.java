Iterator<Book> it = collection.iterator();
Book book;
while (it.hasNext()) {
    book = it.next();
    if (book.getBookName().equals(searchBook)) {
        it.remove();
    }
}