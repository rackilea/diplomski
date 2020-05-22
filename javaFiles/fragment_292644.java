@GET
    @Path ("userlist")
    public Response getUserList() {
        new UserManager();
            com.opensymphony.user.UserManager u = UserManager.getInstance();
        EventPublisher e = null;
        DefaultUserManager users = new DefaultUserManager(u, e);
        Collection<User> listOfUsers = users.getAllUsers();
        return Response.ok(createJSON(listOfUsers).toString()).cacheControl(NO_CACHE).build();
    }