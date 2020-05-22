public Integer findQTYofUsedBooks(){  // although I would suggest to go for a Long
    Integer qty = 0;
    for( Book book: myAudioBooks ) {    // forEach loop in java
      if(book.isUsed()) {
        qty += book.getQTY();    
      }
    }
    return qty;
}