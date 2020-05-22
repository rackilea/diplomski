@GET
@Path("/{columns: .*}")
public Response getMappings(@PathParam("columns") String columns) {
    return Response.status(200).entity(columns).build();
}

// Result: columns_1_=0&columns_1__name_=