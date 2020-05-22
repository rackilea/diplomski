//The public type Book must be defined in its own file 

//public class Book{
//    public String title;
//    public String author;
//    public int numPages;
//}   

public class App
{
    public static void main(String [] args)
    {
          Book book1 = new Book();
          book1.title = "Harry Potter";
          book1.author = "JK Rowling";
          book1.numPages = 400;

          System.out.println(book1.title);

          Book book2 = new Book();
          book2.title = "Lord of the Rings";
          book2.author = "JRR Tolkien";
          book2.numPages = 300;

          System.out.println(book2.title);
    }
    public static class Book{
        public String title;
        public String author;
        public int numPages;
    }

}