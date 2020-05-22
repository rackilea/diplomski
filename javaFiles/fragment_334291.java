@GET
@Produces(MediaType.APPLICATION_JSON)
public Response getSample(@QueryParam("business") String business, 
                          @QueryParam("year") String year,
                          @QueryParam("sample") String sampleId {
    ...
}