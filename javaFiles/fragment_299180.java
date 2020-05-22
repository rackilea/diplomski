public class Book{
         private String name, genre, author;
         //This is called a constructor that instantiates Book objects
        public Book(String name, String genre, String author){
          //now you build the book object by assigning THIS particular book object with the passed in values
           this.name = name;
           this.genre = genre;
           this.author = author;
    }
}