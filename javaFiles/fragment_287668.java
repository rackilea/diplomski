public class Library{
ArrayList<Book> books = new ArrayList<>();

public void AddBook(String a, String b, String c, int ab, int ac) {
    books.add(new Book(a,b,c,ab,ac));
}

public void showBooks(){
    System.out.println(books);
}

public static void main(String[] args) {

    Library l1 = new Library();
    l1.AddBook("Adad", "dasdasd", "asdasdasdas", 2121, 31);
    l1.showBooks();
}
}