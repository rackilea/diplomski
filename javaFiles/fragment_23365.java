@Path("dom")
public class DomXmlResource {

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getXml() throws Exception {
        ...
        StreamingOutput entity = new StreamingOutput() {
            @Override
            public void write(OutputStream out)
                    throws IOException, WebApplicationException {
                ...
            }
        };
        return Response.ok(entity)
                .header(HttpHeaders.CONTENT_DISPOSITION, 
                        "attachment;filename=file.xml")
                .build();
    }
}