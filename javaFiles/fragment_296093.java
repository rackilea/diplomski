private int numberOfBooks = 0;
public void addBook(Book newBook) {
    numberOfBooks++;
    if(numberOfBooks >= catalog.length) {
        // Rebuild array
        Book[] copy = new Book[catalog.length * 2]
        for(int i=0; i<catalog.length; i++){
            copy[i] = catalog[i];
        }
        catalog = copy;
    }
    catalog[numberOfBooks] = newBook;
}