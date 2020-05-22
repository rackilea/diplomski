@Override
public String apply(ContainerRequestContext requestContext) {
    ContainerRequest containerRequest = (ContainerRequest)requestContext;
    Model model = containerRequest.readEntity(Model.class);
    ...
}