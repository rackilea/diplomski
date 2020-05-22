private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .baseUrl(Const.URL.UrlService)
                    .addConverterFactory(JacksonConverterFactory.create());


   public static <S> S createService(Class<S> serviceClass) {

        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }
}