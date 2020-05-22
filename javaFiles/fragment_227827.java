public class HeaderInterceptor implements Interceptor {
@Override
public Response intercept(Chain chain)
        throws IOException {
    Request request = chain.request();
    request = request.newBuilder()
            .addHeader("Cookie", "laravel_session=eyJpdiI6Im54UEpmbW9qdlc0a01FdG1uSGdNU3c9PSIsInZhbHVlIjoieGNuck96K0V2UWU1aG1vVE9DRDRQeWNQbEJ0UldEdWt2TUxFWjByVGVxckZ1a1NhcnE5dXMxTDBqTGtrcExQVEwzWkNQcTNSeHpUVXpFU3A5NHYxdEE9PSIsIm1hYyI6IjhlMzY0ODllYzEwOTFkNTYzZDU2ZmY1NTM5YTUyNmE0MTVlY2JmMjJkZDk0YmFiZmVhNDJmZDNkZmMwMTg5YWIifQ%3D%3D")
            .build();
    Response response = chain.proceed(request);
    return response;
}