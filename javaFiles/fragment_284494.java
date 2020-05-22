@POST
@Path("/GetHrMsg/json_data")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public void gethrmessage(RequestBody requestBody) {
    System.out.println(requestBody.hello);
    System.out.println(requestBody.foo);
    System.out.println(requestBody.count);
}