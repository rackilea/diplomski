@Path("/myendpoint")
@POST
@Consumes(MediaType.APPLICATION_JSON)
public String receiveRequest(String json) {
    JSONObject jo = new JSONObject(json);
...
}