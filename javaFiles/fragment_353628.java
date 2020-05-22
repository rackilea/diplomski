public  interface Rest {

        @GET
        @Path(value="/unhash/{hash}")
        @Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

        Response decryptToken(@PathParam("hash") String token) throws Exception;

}