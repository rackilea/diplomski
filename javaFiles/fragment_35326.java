OkHttpClient okClient = new OkHttpClient();

 okClient.interceptors().add(new Interceptor() {
       @Override
       public Response intercept(Interceptor.Chain chain) throws IOException {
            Request original = chain.request();

            // Request customization: add request headers
            Request.Builder requestBuilder = original.newBuilder()
                    .header("Authorization", token)
                    .method(original.method(), original.body());

            Request request = requestBuilder.build();
            return chain.proceed(request);
        }
 });