public class Library {
    private final Map<String, String> books;

    public Library(Map<String, String> books) {
        this.books = books;
    }

    public int size() {
        return books.size();
    }

    public static void main(String[] args) {
        Map<String, String> myBooks  = new HashMap<String,String>();
        myBooks.put("Jonathan Swift", "Gullivers Travels");
        myBooks.put("Robert Louis Stevenson", "Treasure Island");
        myBooks.put("William Shakespeare", "Hamlet");
        myBooks.put("J R R Tolkein", "The Hobbit");
        myBooks.put("Mary Shelley", "Frankenstein");
        Library library = new Library(myBooks);
        myBooks.put("J K Rowling", "Harry Potter and the Philosophers stone");
        System.out.println("Library contains" + library.size() + " books");
    }
}