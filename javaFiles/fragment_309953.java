public List<Book> findNotUsedBooks(){

    List<Book> notUsedBooks = new ArrayList<>();
    
    for( Book book: myAudioBooks ) {   // same trick as before just this time we add to a list of books
      if( !book.isUsed()) {
        notUsedBooks.add(book);
      }
    }
    
    return notUsedBooks;
}