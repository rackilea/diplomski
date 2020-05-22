...... MORE ROUTES
@POST
@Path("new")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Property createProperty(@Valid Property property){
    return property;
}
...... MORE ROUTES