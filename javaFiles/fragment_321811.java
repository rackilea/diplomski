public void onCreate(){
    getBooks();
    //here b might be empty
}
public void afterGettingBooks(){
    //here b will have retrieved data
}
private void getBooks(){
    //code
    call.enqueue(new Callback<ArrayList<Book>>() {
        @Override
        public void onResponse(Call<ArrayList<Book>> call, Response<ArrayList<Book>> response) {
            //upadte b
            afterGettingBooks();
            }
        }
        @Override
        public void onFailure(Call<ArrayList<Book>> call, Throwable t) {

        }
    });
}