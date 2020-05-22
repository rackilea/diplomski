@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)    
@Produces(MediaType.APPLICATION_JSON)
@Path("/multipleFiles")
public String restDemo(FormDataMultiPart formParams) {
    formParams.getFields();
}