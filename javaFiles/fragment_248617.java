private static Set<Book> books; // do not use raw-types

static {
    books = new HashSet<>(); // diamond operator
    books.add(new Book(1, "C++", 10, "ABC")); // need to close the .add() call
    books.add(new Book(2, "Java", 20, "DEF"));
}

public static Set<Book> allBooks() {
    return books;
}