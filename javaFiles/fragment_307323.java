@POST
@Path("/upload")
public void upload(@FormParam("xml") String xml) {
  try {
    Document doc = this.parse(xml);
  } catch (SAXException ex) {
    throw new WebApplicationException(
      ex,
      Response.status(HttpURLConnection.HTTP_BAD_REQUEST).build()
    );
  }
}