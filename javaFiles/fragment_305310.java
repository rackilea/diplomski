Store store = Session.getDefaultInstance().getStore();
Folder[] folder = store.list(Folder.SENT);
Folder sent = folder[0];
Message msg = new Message(sent);
Address receipent[] = new Address[1];
 try
  {
    receipent[0] = new Address(To_Address, name);
                         msg.addRecipients(Message.RecipientType.TO, receipent);
                         msg.setSubject("Test Mail");
                         msg.setContent("This mail is to remind you that programmatically we can send the mail");
                         msg.setPriority(Priority.HIGH);
                         Transport.send(msg);
                 }

   catch (Exception e)
        {
               e.printStackTrace();
          }