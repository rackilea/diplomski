@Service
@Path("/attachments")
public class AttachmentsController {

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public Response uploadBodyMissing() {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response upload(@FormDataParam("attachment") InputStream attachmentInputStream,
                           @FormDataParam("attachment") FormDataContentDisposition attachmentFileDetail) {

        if (null == attachmentInputStream
                || null == attachmentFileDetail
                || null == attachmentFileDetail.getFileName()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        // receiving, storing file, returning 201 Created responses etc.
    }

}