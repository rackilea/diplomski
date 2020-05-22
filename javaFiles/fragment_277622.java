public static void main(String[] args) {
  String author = ...;
  String title = ...;
  int ref = ...;
  book book1 = new book(); // create book object calling no-parameter version
  book book2 = new book(author, title, ref); // create book object calling one-parameter
                                // (of type String) version
}