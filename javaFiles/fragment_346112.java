@GET
@Produces(MediaType.APPLICATION_JSON)
public Users getUsers(){
    Users users = new Users ();
    users.setAllUsers (userService.getAllUsers());
    return users;
}