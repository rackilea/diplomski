@GET
@Path("/get")
@Produces(MediaType.APPLICATION_JSON)
public Track getTrackInJSON(@Context HttpServletRequest request) {

    if (request.getRequestedSessionId() == null ||
        request.getSession(false) == null) {
        throw new IllegalStateException("NOT_FOUND");
    }
}