class Book
{
    //private fields
    private final String title;
    private final String author;
    private Status available = true;
    //note--i would prefer using an Enum called status for this, 
    //but a boolean true/false value works adequately

    //Constructor
    public Book(string title, string author) {}

    //accessors for title, author, available
    //setter for available--used for Library only--there are better ways to ensure
    //Patrons can't set the status of the book, but for now this is the simplest way
}