public Response getClienteFornitore(
    @ApiParam(value = "Authorization token", required = true) @HeaderParam("Authorization")  String authorization,
    @HeaderParam("StaySignedIn")  boolean staySignedIn, 
    @PathParam("clienteFornitoreId") int clienteFornitoreId) {
    ...
}