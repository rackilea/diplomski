public static void main(String[] args) {
    String file = "books.csv";
    List<Book> books = getList(file);
    for(Book b : books){
        System.out.println(b);
    }
}