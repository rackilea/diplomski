GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapter(LoginBeanResponse.class, new LoginBeanResponseDeserializer()).create():

apiClient = new Retrofit.Builder()
    .baseUrl(url)
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    .client(httpClient)
    .build();