Call<RegisterResponseModel> res = apiService.register(sendDatamodel);
res.enqueue(new Callback<RegisterResponseModel>() {
    @Override
    public void onResponse(Call<RegisterResponseModel> call, 
    Response<RegisterResponseModel> response) {

    }

    @Override
    public void onFailure(Call<RegisterResponseModel> call, Throwable t) 
    {
        // Log error here since request failed
        Log.e(TAG, t.toString());
    }
});