@Inject MessageFactory messageFactory;

void test(Recipient recipient){
  Message message = messageFactory.buildMessage("hey there");
  message.send(recipient);
}