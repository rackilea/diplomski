import org.apache.wink.common.model.multipart.InMultiPart;

@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
@Produces(MediaType.APPLICATION_JSON)
@Path("/upload")
public RestResult upload(InMultiPart bimp) {
    List<InPart> parts = new ArrayList<InPart>();
    while(bimp.hasNext()) {
        parts.add(bimp.next());
    }
    // ....
}