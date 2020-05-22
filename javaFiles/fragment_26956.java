public List<Book> filterBooks(List<Book> readingList, String author) {
    List<Book> myList = new ArrayList<>();
    for (Book book : readingList) {
        if(book.getAuthor().equals(author)) {
            myList.add(book);
        }
    }
    return myList;
}