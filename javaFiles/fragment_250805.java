public class Interceptor implements ClientExecutionInterceptor {

    @Override
    public ClientResponse<?> execute(ClientExecutionContext ctx) throws Exception {
        final ClientResponse<?> response = ctx.proceed();

        response
            .getHeaders()
            .putSingle(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML);

        return response;
    }

}

public void getSchools() throws Exception {
    ResteasyProviderFactory.getInstance()
        .getClientExecutionInterceptorRegistry()
        .register( new Interceptor() );

    SchoolSearch service =
            ProxyFactory.create(SchoolSearch.class, SITE_URL);
}