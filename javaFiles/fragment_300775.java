package de.scrum_master.stackoverflow.q60143388;

public class MessageService {
  MessageBuilder messageBuilder;

  public RequestMessage getMessage(String id) {
    return messageBuilder.buildNew(id);
  }
}