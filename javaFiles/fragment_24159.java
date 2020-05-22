package com.binosaurs.sf.backend.handler;
    import javax.ws.rs.core.Response;
    import javax.ws.rs.core.MediaType;
    import javax.ws.rs.Consumes;
    import javax.ws.rs.POST;
    import javax.ws.rs.Path;
    import javax.ws.rs.FormParam;
    import javax.ws.rs.Produces;
    import org.apache.log4j.Logger;



    @Path("/authentication")
    public class AuthenticationHandler {

        final static Logger log = Logger.getLogger(AuthenticationHandler.class);

        @POST
        @Secured
        @Path("/request_token")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
        public Response authenticateUser(@FormParam("username") String username,
                @FormParam("password") String password) {

            try {

                // Authenticate the user using the credentials provided
                authenticate(username, password);

                // Issue a token for the user
                String token = issueToken(username);

                // Return the token on the response
                return Response.ok(token).build();

            } catch (Exception e) {
                return Response.status(Response.Status.UNAUTHORIZED).build();
            }
        }



        private boolean authenticate(String username, String password) throws Exception {
            return true;
        }

        private String issueToken(String username) {
            return "Tokenized";
        }

    }