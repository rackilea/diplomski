@POST
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public User create(
        @FormParam("username") String username,
        @FormParam("password") String password,
        @FormParam("mobile") String mobile,
        @FormParam("email") String email) {
    User user = new User();
    user.setUsername(username);
    user.setMobile(mobile);
    user.setEmail(email);
    user.setPlainPassword(password);
    userDao.save(user);
    return user;
}

@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.APPLICATION_JSON)
public User createUser(
        @FormDataParam("username") String username,
        @FormDataParam("password") String password,
        @FormDataParam("mobile") String mobile,
        @FormDataParam("email") String email) {
    User user = new User();
    user.setUsername(username);
    user.setMobile(mobile);
    user.setEmail(email);
    user.setPlainPassword(password);
    userDao.save(user);
    return user;
}