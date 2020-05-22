Transport t = session.getTransport();
t.connect();
try {
  for(Message m : messages) {
    m.saveChanges();
    t.sendMessage(m, m.getAllRecipients());
  }
} finally {
  t.close();
}