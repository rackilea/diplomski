public class ListBook {

    private static String[] defaultBooks = {"Necromonicon", "The Hobbit", "Hannibal", "Cooking an egg", "The Hulk smashes again", "The Tyranny of a king",
            "The Phantom Menace", "Rogue One: A Starwars Story", "The Mighty Hercules", "The Serpents Gaze", "The End of the World"};

    private String[] bookList;

    public ListBook() {
        this(defaultBooks);
    }

    public ListBook(String[] books) {
        bookList = books;
    }

    public void printList() {
        for (String x : bookList) {
            System.out.println(x);
        }
    }
}