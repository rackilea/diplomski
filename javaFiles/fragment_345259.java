class Library
{
    private final ArrayList<Book> books;

    //Constructor
    public Library ()
    {
        books = loadBooks();
    }

    //some methods
    private ArrayList<Book> loadBooks () {}
    //however you want to create all your books (file input, whatever)

    public bool isBookAvailable (Book b)
    {
        if b isn't in library: return false
        else return (b in books).isAvailable()
    }

    public Book checkoutBook (Book b)
    { get book (checking availability, possibly returning a null Book), set status to unavailable, return it }

    public Book checkinBook (Book b)
    { check that this the book belongs to library, set status to available }
}