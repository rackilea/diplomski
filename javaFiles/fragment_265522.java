@Path("/say")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(String name)
    {
        return "hello "+name;

    }