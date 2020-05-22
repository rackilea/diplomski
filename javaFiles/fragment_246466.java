@GET
    @Path("/Child/{Child:[0-9]+}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response Child(@PathParam("Child") int child) throws IOException {
        return Response.status(200).build();
    }