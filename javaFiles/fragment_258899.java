// maybe make a bean of this
private final ObjectMapper mapper = new ObjectMapper();

@KafkaListener(topics = "my-topic")
public void handleAsUser(@Payload String message) throws IOException {

    if (message.contains("age")){

        User userMessage = mapper.readValue(message, User.class);

        // do something when a user message is received
        return;          
    }
    System.out.println("The message is of type String");
}