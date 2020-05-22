public class Library {
    private int capacity;
    private Book[] books;                     // *** Don't initialize it here
    public Library(int capacity) {
        if (capacity > 1) {
            this.capacity = capacity;
        }
        else {
            this.capacity = 4;
        }
        this.books = new Book[this.capacity]; // *** Initialize it here
    }