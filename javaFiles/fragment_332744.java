public class HelloWorld {

@POST
@Path("/post")
@Consumes("text/plain")
public Response getNumber(String a){
    return Response.status(201).entity("Number is: "+a.toString()).build();
}
}