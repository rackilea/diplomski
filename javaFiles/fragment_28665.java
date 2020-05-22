@JsonDeserialize(using = MessageDeserializer.class)
public class Message {
    String language;
    String data;
}

public class MessageDeserializer extends JsonDeserializer<Message> {

    public MessageDeserializer() {
        super();
    }

    @Override
    public Message deserialize(
            final JsonParser jsonParser, final DeserializationContext deserializationContext) throws
            IOException, JsonProcessingException {
        final String messageText = jsonParser.getText(); 
        // parse messageText into Message object
    }
}