@GET    
public Response filterQuery(@QueryParam("filter") String filterQuery) {
    if (filterQuery == null) {
        return filter();
    }
    return Response.accepted("filter: " + filterQuery).build();
} 

private Response filter() {  
    return Response.accepted("Hello world").build();
}