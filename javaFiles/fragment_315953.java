// Use the following to e.g. GET /places/123/comments/42
@Path("{id}/{otherStuff: [a-zA-Z0-9_/]+}")
public PlaceResource place(@PathParam("id") int id) {
    Place p = DAO.getInstance().getPlace(id);
    return new PlaceResource(p); // singular (a different resource class)
}