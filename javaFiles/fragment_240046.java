//Some rest function to showcase
    @POST
    @Path("/path/to/test")
    //Remember @Valid or annotations will not be validated
    public Response callRestTestMethod(@Valid TestClass testObject){
        return Response.ok().build();
    }