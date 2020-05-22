@GET
@Path("/GetUsers")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public List<User> findUsers(@BeanParam UserQueryParams userQuery) {
    List<User> users = userBL.getUsers(userQuery);
    return users;
}