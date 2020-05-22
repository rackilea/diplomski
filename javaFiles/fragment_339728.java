...
    // send the org.apache.commons.mail.HtmlEmail
    email.send();
    copyIntoSent(email.getMailSession(), email.getMimeMessage());
}

private void copyIntoSent(final Session session, final Message msg) throws MessagingException
{
    final Store store = session.getStore("imaps");
    store.connect(IMAP_HOST, SMTP_AUTH_USER, SMTP_AUTH_PWD);

    final Folder folder = (Folder) store.getFolder("Sent Items");
    if (folder.exists() == false) {
        folder.create(Folder.HOLDS_MESSAGES);
    }
    folder.open(Folder.READ_WRITE);

    folder.appendMessages(new Message[] { msg });
}