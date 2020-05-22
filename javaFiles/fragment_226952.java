OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
Retrofit retrofitClient = new Retrofit.Builder()
        .baseUrl("http://[domain]/path/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(httpClient.build())
        .build();
AppApi appApi = retrofitClient.create(AppApi.class);
Call<List<PojoItem>> call = appApi.getItemsbyRetrofit();
call.enqueue(new Callback<List<PojoItem>>() {
    @Override
    public void onResponse(Call<List<PojoItem>> call, Response<List<PojoItem>> response) {
        for (PojoItem pojoItem : response.body()) {
            Log.d(TAG, pojoItem.field1() + "," + pojoItem.field2());
        }
    }

    @Override
    public void onFailure(Call<List<PojoItem>> call, Throwable t) {
        Log.e(TAG, t.getMessage());
    }
});