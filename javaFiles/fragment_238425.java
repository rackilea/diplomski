public class InterceptorTest  {

    @Path("/")
    public static class MyService {

        @GET
        public String listByName(@QueryParam("name") String name){
            return "not-intercepted-" + name;
        }
    }

    public static class MyInterceptor implements PreProcessInterceptor, AcceptedByMethod {

        @Override
        public boolean accept(Class declaring, Method method) {
            for (Annotation[] annotations : method.getParameterAnnotations()) {
                for (Annotation annotation : annotations) {
                    if(annotation.annotationType() == QueryParam.class){
                        QueryParam queryParam = (QueryParam) annotation;
                        return queryParam.value().equals("name");
                    }
                }
            }
            return false;
        }

        @Override
        public ServerResponse preProcess(HttpRequest request, ResourceMethod method)
                throws Failure, WebApplicationException {

            String responseText = "intercepted-" + request.getUri().getQueryParameters().getFirst("name");
            return new ServerResponse(responseText, 200, new Headers<Object>());
        }
    }

    @Test
    public void test() throws Exception {
        Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
        dispatcher.getProviderFactory().getServerPreProcessInterceptorRegistry().register(new MyInterceptor());
        dispatcher.getRegistry().addSingletonResource(new MyService());

        MockHttpRequest request = MockHttpRequest.get("/?name=xxx");
        MockHttpResponse response = new MockHttpResponse();

        dispatcher.invoke(request, response);

        assertEquals("intercepted-xxx", response.getContentAsString());
    }
}