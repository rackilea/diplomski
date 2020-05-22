XMPPService xmpp = XMPPServiceFactory.getXMPPService();
  Message message = xmpp.parseMessage(req);
  Message reply = new MessageBuilder().withFromJid(message.getRecipientJids()[0])
    .withRecipientJids(message.getFromJid())
    .withBody("Back at you!")
    .build();
  xmpp.sendMessage(reply);