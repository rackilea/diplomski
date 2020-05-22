public class Message {
  private String text;
  private MessageSender sender;

  @Inject
  public Message(@Assisted String text, MessageSender sender) {
    this.text = text;
    this.sender = sender;
  }

  public void send(Person recipient) {
    this.sender.send(recipient, this.text);
  }
}