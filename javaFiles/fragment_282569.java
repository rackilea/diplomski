private static final OkHttpClient okHttpClient = new OkHttpClient.Builder()
        .addInterceptor(getGzipDecodingInterceptor())
        .addInterceptor(getBase64DecodingInterceptor())
        .addInterceptor(getFakeContentInterceptor())
        .build();

private static final Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://whatever")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

private static final IService service = retrofit.create(IService.class);

public static void main(final String... args)
        throws IOException {
    final String body = service.get().execute().body();
    System.out.println(body);
}