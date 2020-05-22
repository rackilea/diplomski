Call<ResponseBody> deleteRequest = mService.deleteBook(123);
deleteRequest.enqueue(new Callback<ResponseBody>() {
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        // use response.code, response.headers, etc.
    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {
        // handle failure
    }
});