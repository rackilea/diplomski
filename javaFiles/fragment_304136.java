class BookByPrice implements ISelect<Book> {

    ...

    public boolean select(Book book) {
        return book.getPrice() >= this.low && book.getPrice() <= this.high;
    }
}