@PreAuthorize("hasAnyRole('ROLE_ANALYST', 'ROLE_DEVELOPER')")
@GET
@Produces(MediaType.APPLICATION_JSON)
public def list(@Context UriInfo ui) {
    ...
}