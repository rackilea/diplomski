class Book extends Entry {

   public String getTitle() {
     ...
   }
}

List<Book> books = new List<Book>();
books.add(new Book(...));
books.add(new Book(...));
books.add(new Book(...));

Sorter sorter = new QuickSorter();
Comparison<Book> byTitle = new Comparison<Book>() {
    public int compare(Book one, Book two) {
      return String.compare(one.getTitle(), two.getTitle());
    }
}
sorter.sort(books, byTitle);