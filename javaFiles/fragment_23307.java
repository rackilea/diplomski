@Override
public ContainerRequest filter(ContainerRequest request) {
    User user = Helper.getCurrentUser();
    if(user == null){
        ResponseBuilder builder = null;
        String response = "Custom message";
        builder = Response.status(Response.Status.UNAUTHORIZED).entity(response);
        throw new WebApplicationException(builder.build());

    }
    return request;
}