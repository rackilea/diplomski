public class EmailBuilder {
  private Email mail;
  private String from;
  private String recipient;
  // other properties

  public EmailBuilder withFrom(String from) {
    this.from = from;
    return this;
  }
  public EmailBuilder withRecipient(String recipient) {
    this.recipient = recipient;
    return this;
  }
  public Email send() {
    mail = new Email(from, recipient, title,emailContent, null, file);
    return mail;
  }
}