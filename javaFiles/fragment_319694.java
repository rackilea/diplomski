public static BookDetail[] readInventory() throws Exception {
    List<BookDetail> books = new ArrayList<BookDetail>();
    java.io.File file = new java.io.File("../instr/prog4.dat");
    try (Scanner fin = new Scanner(file)) {
        String isbn;
        double price = 0;
        int copies = 0;
        while (fin.hasNext()) {
            isbn = fin.next();
            if (fin.hasNextDouble()) {
                price = fin.nextDouble();
            }
            if (fin.hasNextInt()) {
                copies = fin.nextInt();
            }
            BookDetail book = new BookDetail(isbn, price, copies);
            books.add(book);
        }
    }
    return books.toArray(new BookDetail[books.size()]);
}