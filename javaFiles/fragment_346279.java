@Path("/webhookservice")
public class Webhook {

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response readData(@FormParam("payload") String payload, @Context HttpServletRequest req) {
        JAXBContext jaxbContext = JAXBContext.newInstance(Payload.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(payload,);
        Payload payload = (Payload) unmarshaller.unmarshal(reader);

        //...
    }
}