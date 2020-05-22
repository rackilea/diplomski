/**
 * When active, this filter transforms all responses for specified basePath to 200, even in case of error.
 */
@Provider
public class DiscardErrors implements ContainerResponseFilter
{
    private String basePath;

    public DiscardErrors(String basePath)
    {
        this.basePath = basePath;
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext) throws IOException
    {
        if containerRequestContext.getUriInfo().getPath().startsWith(this.basePath) {
            if (containerResponseContext.getStatus() != 200) { // Check if response code is different from 200
                containerResponseContext.setStatus(200); // Force 200 status code
                containerResponseContext.setEntity(""); // Empty body
            }
        }
    }

}