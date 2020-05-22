public class Librarian {
    public static void main(String[] args){
        Library library = new Library();
        //Creating and adding the Fiction Book to the list in a single line of code.
        library.addBook(new FictionBook("Jon", "Title"));
    }
}