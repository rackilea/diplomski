@POST
@Path("/files/{file}")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public Response doTest(@PathParam("file") String fileName, @Context HttpHeaders headers) {
    String accept = headers.getHeaderString(HttpHeaders.ACCEPT);
    return Response.ok(fileName + "; Accept: " + accept).build();
}
...

Map<String, MediaType> map = new HashMap<>();
map.put("xml", MediaType.APPLICATION_XML_TYPE);
resourceCnfig.property(ServerProperties.MEDIA_TYPE_MAPPINGS, map);