@Path("pojo")
public class PojoXmlResource {

    @GET
    @Produces("application/xml")
    public Response getXml() {
        User user = new User();
        user.setName("Jane Doe");

        return Response.ok(user)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment;filename=user.xml")
                .build();
    }
}