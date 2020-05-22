ApiInterface apiService = ApiClient.getClient(1).create(ApiInterface.class);
Call<ApiTime> call = apiService.getTime(location, epoch, GOOG_TZ_KEY);
call.enqueue(new Callback<ApiTime>() {
    @Override
    public void onResponse(Call<ApiTime> call, Response<ApiTime> response) {
        int statusCode = response.code();
        Log.e("main", "apt " + response.body());
    }

    @Override
    public void onFailure(Call<ApiTime> call, Throwable t) {
        Log.e("getFS ", t.toString());
    }
});