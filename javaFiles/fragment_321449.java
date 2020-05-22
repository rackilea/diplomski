Date joiningdate;
@GET
@Produces("application/xml")    
public Employee(@PathParam("joiningdate") Date joiningdate, @Context Request req, 
        @Context UriInfo ui) {

    this.joiningdate = joiningdate;
    ...
    this.tag = computeEntityTag(ui.getRequestUri());
    if (req.getMethod().equals("GET")) {
        Response.ResponseBuilder rb = req.evaluatePreconditions(tag);
        // Preconditions met
        if (rb != null) {
            return rb.build();
        }
        // Preconditions not met
        rb = Response.ok();
        rb.tag(tag);
        return rb.build();
    }
}