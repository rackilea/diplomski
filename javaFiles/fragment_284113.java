@Provider
public class SomeFilter implements ContainerRequestFilter {

    @Inject
    private SomeBean someBean;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        someBean.setFoo("bar");
    }

}