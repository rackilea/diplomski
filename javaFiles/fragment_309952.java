public Integer findQTYofUsedBooks(){  
    return myAudioBooks.stream()                   // iterate
                .filter(book -> book.isUsed())     // keep only used books
                .mapToInt(book -> book.getQTY())   // get QTY 
                .sum();                            // sum the QTY
    }