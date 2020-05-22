@Provider
public class SomeFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        requestContext.setProperty("someProperty", "someValue");
    }

}