service.makeCall(yourCustomString).enqueue(new Callback<Object>() {
    @Override
    public void onResponse(Response<MovieResponse> response) {...}

    @Override
    public void onFailure(Throwable t) {...}
});