public class QueryAndFormParamTest  {

    @Path("/")
    public static class InterceptedResource {
        @GET
        //@Path("/stuff") // uncomment this and it will not work
        public String otherService(@QueryParam("yadda") String name){
            return "Im never called in this example" + name;
        }
    }

    public static class MyInterceptor implements PreProcessInterceptor, AcceptedByMethod {
        @Override
        public boolean accept(Class declaring, Method method) {
            System.out.println("Accepted by method "+method.getName());
            // you can check if this interceptor should act on this method here
            return true; // it'll act everytime
        }

        @Override
        public ServerResponse preProcess(HttpRequest request, ResourceMethod method)
                throws Failure, WebApplicationException {

            // parsing form parameters
            if (request.getHttpHeaders().getMediaType() != null && request.getHttpHeaders().getMediaType().isCompatible(MediaType.valueOf("application/x-www-form-urlencoded"))) {
                MultivaluedMap<String, String> formParameters = request.getFormParameters();
                if (formParameters != null) {
                    for (String key : formParameters.keySet()) {
                        System.out.println("[FORM] "+key + ": "+formParameters.get(key));
                    }
                }
            }

            // parsing query parameters
            MultivaluedMap<String, String> queryParameters = request.getUri().getQueryParameters();
            if (queryParameters != null)
            for (String key : queryParameters.keySet()) {
                System.out.println("[QUERY] "+key + ": "+queryParameters.get(key));
            }

            String responseText = "do something: " + request.getUri().getQueryParameters().getFirst("test");
            return new ServerResponse(responseText, 200, new Headers<Object>());
        }
    }

    @Test
    public void test() throws Exception {
        Dispatcher dispatcher = MockDispatcherFactory.createDispatcher();
        dispatcher.getProviderFactory().getServerPreProcessInterceptorRegistry().register(new MyInterceptor());
        dispatcher.getRegistry().addSingletonResource(new InterceptedResource());

        MockHttpRequest request = MockHttpRequest.get("/?test=someStuff");
        MockHttpResponse response = new MockHttpResponse();

        dispatcher.invoke(request, response);

        System.out.println(response.getContentAsString());
        Assert.assertEquals("do something: someStuff", response.getContentAsString());
    }
}