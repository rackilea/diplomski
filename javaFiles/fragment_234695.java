d = MyClient.getDomains().get(domainID.toString());
if (d == null) {
    throw new NotFoundException();  // <-- JAX-RS 2.0
    // or throw new WebApplicationException(Response.Status.NOT_FOUND);
                                    // ^^  JAX-RS 1.x 
}