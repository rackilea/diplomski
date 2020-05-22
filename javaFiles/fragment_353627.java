@Path("/service")
public class MyFirstRestService implements Rest {

        @Override
        public Response decryptToken(String token) throws Exception {
        // TODO Auto-generated method stub
        String output="It is success-  Path Pram : "+ token;

        return Response.ok(output).build();
        }