POST
@Path("/sessions")
@Consumes("application/json")
public Response createSession(String body){

    JSONObject jsonObject = null;
    try {
        jsonObject = new JSONObject(body);
    } catch (ParseException e) {
        LOGGER.error("This is not a valid JSON " + e);
        return Response.status(400).build();
    }