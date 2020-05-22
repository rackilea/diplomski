abstract class BaseTickets {
    String ticketType;
    public String getTicketType()
}

public class MyListDeserializer extends JsonDeserializer<BaseTickets> {

    @Override
    public BaseTickets deserialize(JsonParser jsonParser, DeserializationContext arg1) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        Iterator<JsonNode> elements = node.getElements();
        for (; elements.hasNext();) {
            String type = (String) elements.next().get("ticketType");

            if (type.equals()){
               //create concrete type here
            }
        }
     }