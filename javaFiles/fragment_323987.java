@GET
public Response getMappings(@QueryParam("columns") List<String> columns) {
    return Response.status(200).entity(columns).build();
}

// URL to be called (with same param names): 
// /mappings?columns=columns[1][name]=0&columns=columns[0][searchable]=false

// Result: [columns[1][name]=0, columns[0][searchable]=false]