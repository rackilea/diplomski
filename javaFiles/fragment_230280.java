@POST
@Path ("/authenticate")
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public Response authenticate (AuthBean auth) {

  //auth bean contains the parsed JSON

}


class AuthBean {

   private String username;
   private String password;

   // getters/setters

}