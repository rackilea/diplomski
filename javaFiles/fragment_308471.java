@POST
@Path("/save")
@Consumes(MediaType.APPLICATION_XML)
public String saveData(YourXmlDataObject obj) {
    return obj.getField();
    }
}