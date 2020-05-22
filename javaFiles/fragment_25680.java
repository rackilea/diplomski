public class MyDynamicFeature implements DynamicFeature {

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        if(resourceInfo.getResourceMethod().getAnnotation(AuthenticateMe.class) != null ) {
            context.register(MyAuthFilter.class);
        }
    }

    public class MyAuthFilter implements ContainerRequestFilter {

        @Override
        public void filter(ContainerRequestContext requestContext) throws IOException {
            // do authentication here
        }

    }

    public @interface AuthenticateMe {

    }

    @Path("myPath")
    public class MyResource {

        @GET
        public String get() {
            return "get-method";
        }

        @POST
        @AuthenticateMe
        public String post() {
            return "post-method";
        }
    }
}