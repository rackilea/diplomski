public void processMailExample() {
   Store store = session.getStore(new javax.mail.URLName("imap://user:pass@mailserver..."));
   store.connect();
   Folder inputFolder = store.getFolder("INBOX");
   Folder outputFolder = store.getFolder("INBOX/Processed");

   inputFolder.open(Folder.READ_WRITE);

   Message[] messages = inputFolder.getMessages();
   for (Message message : messages) {

       // Process message here

       moveMessage(message, outputFolder);
   }
}

public void moveMessage(Message m, Folder to) throws MessagingException
{
    m.getFolder().copyMessages(new Message[] {m}, to);
    m.setFlag(Flag.DELETED, true);
    m.getFolder().expunge();
}