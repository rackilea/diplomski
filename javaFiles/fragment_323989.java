@GET
public Response getMappings(@Context UriInfo uriInfo) {
    MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();

    // In case you want to get the whole generated string
    String query = uriInfo.getRequestUri().getQuery();

    String output = "QueryParams: " + queryParams 
            + "<br> Keys: " + queryParams.keySet() 
            + "<br> Values: " + queryParams.values()
            + "<br> Query: " + query;

    return Response.status(200).entity(output).build();
}

// URL: /mappings?columns[1][name]=0&columns[0][searchable]=false

/* Result:
 *  QueryParams: {columns[0][searchable]=[false], columns[1][name]=[0]}
 *  Keys: [columns[0][searchable], columns[1][name]]
 *  Values: [[false], [0]]
 *  Query: columns[1][name]=0&columns[0][searchable]=false
 */