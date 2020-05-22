class Book
{
    private String bookNo;
    private int price;
    private int stock;

    public Book(String bookNo, int price, int stock) {
        this.bookNo = bookNo;
        this.price = price;
        this.stock = stock;
    }

    public String getBookNo() {
        return bookNo;
    }
    public int getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Book) {
            if(this.bookNo.equals(((Book) obj).bookNo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.bookNo.hashCode();
    }
}