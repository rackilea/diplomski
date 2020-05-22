public String returnByBookID(int enterBookId) {

    Iterator<Book> it = books.iterator();
    while(it.hasNext()) {
        Book books =  it.next();
        if(books.idNumber == (enterBookId)){

            return books.title ;
        }
    }
    return "ID not found";
}