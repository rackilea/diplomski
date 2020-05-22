@GET
public Response getSomething(@Context UriInfo info) {
    for (PathSegment segment : info.getPathSegments()) {
        MultivaluedMap matrixParameters = segment.getMatrixParameters();
        ...
    }
}