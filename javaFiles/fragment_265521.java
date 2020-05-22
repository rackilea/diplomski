@Path("/say")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello()
    {
        return "hello";

    }