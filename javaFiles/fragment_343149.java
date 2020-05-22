public class Library {
    private HashMap<String, Book> collection;

    public Library() {
        collection = new HashMap<>();
    }

    public Book getBook(String name) {
        return collection.get(name);
    }

    public void addBook(String name, Book book) {
        collection.put(name, book);
    }
}

public class Book {
    private boolean isLend;

    public boolean isLend() {
        return isLend;
    }
}