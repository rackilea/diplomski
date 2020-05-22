class MyInterceptor implements Interceptor {
   @Override
   Response intercept(Interceptor.Chain chain) throws IOException {
    Request request = chain.request()
    String stringurl = request.url().toString()
    stringurl = stringurl.replace("%26", "&")

    Request newRequest = new Request.Builder()
        .url(stringurl)
        .build()

    return chain.proceed(newRequest)
 }
}