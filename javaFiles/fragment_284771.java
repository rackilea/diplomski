class Book{
    private String author;
    private String title;

    //getters and setters
}


class Library {

    private List<Book> bookList = new ArrayList<Book>();

    public String checkForBookUsingInfo(String author, String title){
        for (Book book : bookList){
            if (book.getAuthor().equals(author) && book.getTitle().equals(title)){
                return "Book is in library.";
            }
        }
        return "Book not found in library";
    }

    public static void main(String[] args) throws Exception {
        Scanner keybd = new Scanner(System.in);
        Library library  = new Library();
        //add some books to library
        //....

        System.out.println("Please enter title of book to search for.");
        String anyTitle = keybd.nextLine();

        System.out.println("Please enter author of book to search for.");
        String anyAuthor = keybd.nextLine();

        String stateOfBook = library.checkForBookUsingInfo(anyAuthor, anyTitle);
        System.out.println(stateOfBook);

    }
}