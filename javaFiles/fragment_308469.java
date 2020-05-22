@GET
@Path("/save")
@Produces(MediaType.TEXT_XML)
public String saveData(@QueryParam("xmlData") String xml) {
    return xml;
    }
}