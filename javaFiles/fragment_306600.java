@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Response createUser(String request) {
    Gson gson = new Gson();
    UserCreateRequest user = gson.fromJson(request, UserCreateRequest.class);
    return user.getHandler().handle();
}