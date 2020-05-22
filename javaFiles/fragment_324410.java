public class Menu {
     public Menu(Input reader, 
                Output writer, 
                Library library, 
                PrintBooksOperation printItemsOfTypeBook, 
                PrintMoviesOperation printItemsOfTypeMovie, 
                LoginAccountOperation loginAccount, 
                QuitOperation quit) {
           this.reader = reader;
           this.writer = writer;
           this.library = library;
           this.printItemsOfTypeBook = printItemsOfTypeBook;
           this.printItemsOfTypeMovie = printItemsOfTypeMovie;
           this.loginAccount = loginAccount;
           this.quit = quit;
     }
}