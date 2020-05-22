HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://backend.example.com")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

return retrofit.create(ApiClient.class);