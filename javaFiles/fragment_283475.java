@MyNewFilter
public class MyNewFilterImpl implements ContainerRequestFilter {
  @Override
  public void filter(ContainerRequestContext context) {      
    if (... feature is enabled )) {
        ... nothing to do
    } else {
        context.abortWith(
                Response.status(Response.Status.NOT_IMPLEMENTED).entity("not implemented").build());
    }
}