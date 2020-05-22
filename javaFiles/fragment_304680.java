/*
   Corrected code:
 */
public void displayBooksFromAuthor(String author) {
    for(Book b : bookList) {
        if(b.author.equals(author))
            System.out.println(b);
    }
}