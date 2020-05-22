class A extends ServerResource {
    UserFacade userFacade;

    @Override
    protected void doInit() throws ResourceException {
      this.userFacade = userFacade;
    }

    @Get
    public String getUsers() {
        String userJson = null;
        // database call: want to return resources
        List<Resource> resources = userFacade.getDrUsersByExample();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        userJson = gson.toJson(resources);
        return userJson ;
    }

    public void setUserFacade(UserFacade userFacade) {
        this.userFacade= userFacade;
    }
}