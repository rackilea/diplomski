@Async
public void deleteEmailAsync(Email email) {
    LOGGER.debug("Deleting email: " + email.getSubject());

    Properties properties = getServerProperties(this.protocol, this.host, this.port);
    Session session = Session.getDefaultInstance(properties);

    try {
        // connects to the message store
        Store store = session.getStore(protocol);
        store.connect(this.userName, this.password);

        // opens the inbox folder
        Folder folderInbox = store.getFolder("INBOX");
        folderInbox.open(Folder.READ_WRITE);

        // fetches new messages from server
        Message[] messages = folderInbox.getMessages();

        for (int i = 0; i < messages.length; i++) {
            Message msg = messages[i];
            Address[] fromAddress = msg.getFrom();
            if (fromAddress[0].toString().contains(email.getFrom()) 
                    && msg.getSubject().equals(email.getSubject()) ) {
                msg.setFlag(Flags.Flag.DELETED, true);
            }
        }

        // disconnect
        folderInbox.close(true);
        store.close();

    } catch (NoSuchProviderException e) {
        LOGGER.error("No provider for protocol: " + protocol + " " + e.getMessage());
    } catch (MessagingException e) {
        LOGGER.error("Could not connect to the message store " + e.getMessage());
    } 
}