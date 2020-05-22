@POST
@Path("/save")
@Produces(MediaType.TEXT_XML)
public String saveData(String xml) {
    return xml;
    }
}