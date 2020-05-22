import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("response_test")
@GET
public Response response(){

    // Pretend we've got a response builder that was created by 
    // some code we don't control
    ResponseBuilder builder = Response.status(200);
    builder.entity("Test Me");
    builder.header("content-disposition", "attachment; filename=a.txt");

    // Now remove any "content-disposition" header that's there
    // and replace it with our updated header.
    builder.header("content-disposition", null);
    builder.header("content-disposition", "attachment; filename=b.txt");
    Response response = builder.build();
    return response;
}