GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(new GsonBuilder().registerTypeAdapterFactory(AutoValueGsonFactory.create()).create());
OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
Retrofit retrofitClient = new Retrofit.Builder()
        .baseUrl("http://[domain]/path/")
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(httpClient.build())
        .build();

AppApi appApi = retrofitClient.create(AppApi.class);

appApi.getItemsbyRxJava()
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<List<PojoItem>>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "completed");
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.getMessage());
            }

            @Override
            public void onNext(List<PojoItem> list) {
                for (PojoItem pojoItem : list) {
                    Log.d(TAG, pojoItem.field1() + "," + pojoItem.field2());
                }
            }
        });