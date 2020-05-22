@Provider
@PreMatching
public class UserFilter implements ContainerRequestFilter {

    public static final String USER_PROP = "user";

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        requestContext.setProperty(USER_PROP, new User("peeskillet"));
    }
}