public class AuthInterceptor implements Interceptor {

    Config config = Config.getInstance();
    @Override
    public Response intercept(Chain chain) throws IOException
    {

        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("X-AUTH-TOKEN", config.token).build();

        return chain.proceed(request);
    }
}