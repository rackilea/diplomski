import org.glassfish.jersey.media.multipart.ContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

@POST
@Path("update")
@Consumes(MediaType.WILDCARD)
public boolean updateWorkBookMaster(FormDataMultiPart multiPartData) {
    try {
        final FormDataBodyPart workBookFilePart = multiPartData.getField("workBookFile");
        final ContentDisposition workBookFileDetails = workBookFilePart.getContentDisposition();
        final InputStream workBookFileDocument = workBookFilePart.getValueAs(InputStream.class);

        if (workBookFileDetails.getFileName() != null || 
            workBookFileDetails.getFileName().trim().length() > 0 ) {
            // file is present
        } else {
            // file is not uploadded
        }
    } ... // other code
}