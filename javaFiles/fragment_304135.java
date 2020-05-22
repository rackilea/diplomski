class BookByPrice<T extends Book> implements ISelect<T> {

    ...

    public boolean select(T book) {
        return book.getPrice() >= this.low && book.getPrice() <= this.high;
    }
}