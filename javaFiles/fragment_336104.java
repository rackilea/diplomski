public interface BookService{
    @GET("/books")
    void getBooks(Callback<List<Book>> books);
}

// AND THEN

private Callback genericCallbackListener = new Callback<List<Book>>() {

    @Override
    public void success(List<Book> books, Response response) {
        [...] // use books
    }

    @Override
    public void failure(RetrofitError retrofitError) {

    }
}

taskService.getBooks(genericCallbackListener);