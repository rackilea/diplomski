@Override
public void filter(ContainerRequestContext requestContext) throws IOException {
    UriInfo info = requestContext.getUriInfo();
    if (!info.getPath().contains("secured")) {
        return;
    }
}