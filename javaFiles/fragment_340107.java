final Chat newChat = ChatManager.getInstanceFor(xmppConn).createChat(userJid, new MessageListener() {
    @Override
    public void processMessage(final Chat arg0, final Message arg1) {
      LOG.info("Sent message: " + arg1.getBody());
    }
  });
  try {
    final Message message = new Message();
    message.setFrom(chatProperties.getDomain());
    message.setTo(userJid);
    message.setType(Type.normal);
    message.setBody(text);
    message.setSubject("");
    newChat.sendMessage(message);
    xmppConn.disconnect();
  } catch (final Exception e) {
    LOG.error("Error while sending message to " + userName + ": ", e);
  }