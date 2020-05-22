deleteRequest.enqueue(new Callback<Void>() {
    @Override
    public void onResponse(Call<Void> call, Response<Void> response) {
        // use response.code, response.headers, etc.
    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {
        // handle failure
    }
});