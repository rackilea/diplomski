import javax.ws.rs.*;

@Path("/uploadImage/")
@Produces("application/json")
@Consumes("*/*")
public interface ImagePostWebService {
    /**
     * A Web service that handles tokens
     */
        @POST
        String postPicture(@FormParam("image") String image);
}