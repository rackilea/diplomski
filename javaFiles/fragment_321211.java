class MobileListAdapter implements Products {
    private MobileList mobileList;

    public void add(Product mobile) {
        mobileList.addMobileToList(mobile);
    }

    public Product get(int index) {
        return mobileList.getMobileAtIndex(index);
    }
}

class BookListAdapter implements Products {
    private BookList bookList;

    public void add(Product book) {
        bookList.add(book);
    }

    public Product get(int index) {
        return bookList.getAllBooks()[index];
    }
}