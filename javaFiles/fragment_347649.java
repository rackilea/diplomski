class Cart {

    ArrayList<Book> books;

    Cart() {
        books = new ArrayList<>();
    }

    public void addToCart(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getCart() {
        return books;
    }

}