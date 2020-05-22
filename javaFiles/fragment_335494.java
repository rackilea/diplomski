public Message addMessage(Message message) {
  //null checks and duplicate checks omitted
  messages.add(message);
  message.setOwner(this);
  return message;
}