Folder folder = store.getFolder("INBOX");
folder.open(Folder.READ_WRITE);
folder.addMessageCountListener(new MessageCountAdapter() {
    public void messagesAdded(MessageCountEvent ev) {
        Folder folder = (Folder)ev.getSource();
        Message[] msgs = ev.getMessages();
        System.out.println("Folder: " + folder +
            " got " + msgs.length + " new messages");
        try {
            // process new messages
            idleManager.watch(folder); // keep watching for new messages
        } catch (MessagingException mex) {
            // handle exception related to the Folder
        }
    }
});
idleManager.watch(folder);