private static Book[] books;
private static final int  MAX_BOOKS = 10;
private static int count;

public static void main(String[] args) {
    books = getBooks();
    bookMenu();
}

public static Book[] getBooks() {
    if(count == MAX_BOOKS) {
        JOptionPane.showMessageDialog(null, "Catalogue full - cannot add any more books");
    } else {
        for(; count < MAX_BOOKS; count++) {
            books[count]= addBook();
        }
    } 
    return books;
}