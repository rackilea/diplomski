private static void addBook() {
    // TODO Auto-generated method stub
    int isbn;
    String title, author;
    double price;

    System.out.println("\nEnter Title: ");
    title = in.nextLine();

    System.out.println("\nEnter Author: ");
    author = in.nextLine();

    System.out.println("\nEnter ISBN: ");
    isbn = in.nextInt();

    System.out.println("\nEnter Price: ");
    price = in.nextDouble();

    Book b = new Book(isbn, title, author, price);
    lib.addBook(b);
}