@GET
@Path("name")
@Produces(MediaType.TEXT_HTML)
public Viewable displayForm() {
    return new Viewable("/display_name.html");
}