public class Library {
   private static final Library instance = new Library();
   private List<Book> books = new ArrayList<Book>();

   public static Library getInstance() {
       return instance ;
   }

   public void add(Book book) { 
       books.add(book);
   }
}