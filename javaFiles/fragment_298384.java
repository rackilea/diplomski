@Context
private HttpServletRequest request;

@POST
@Path("/")
public Response consumeRequest() {
    try {
        final BufferedReader rd = new BufferedReader(new InputStreamReader(
                request.getInputStream(), "UTF-8"));

        String line = null;
        final StringBuffer buffer = new StringBuffer(2048);

        while ((line = rd.readLine()) != null) {
            buffer.append(line);
        }
        final String data = buffer.toString();
        return Response.ok().entity(data).build();
    } catch (final Exception e) {
        return Response.status(Status.BAD_REQUEST)
                .entity("No data supplied").build();
    }
}