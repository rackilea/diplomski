class Patron
{
    private final String name;
    private final Book[] books = new Book[3];//you can see I'm limiting them to 3 books
    private int index = 0;

    //Constructor
    public Patron (String name) {}

    //methods
    public void checkoutBook (Book b, Library l)
    {//could be tricky
        check books status in l (l.isBookAvailable(b))
        if available: 
            if space (index < 2) Book newBook = l.checkoutBook(b); books[index++] = newBook;
            else: no space
        else: not available
    }

    public void checkinBook (int bookIndex, Library l)
    {
         if bookIndex < 3:
             if books[index] != null:
                 l.checkinBook (books[index]);
                 books[index--] = null;
             else: no book
         else: not valid index
    }
}