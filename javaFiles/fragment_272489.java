public static void checkMail(String username, String password) {
    Properties props = new Properties();
    props.setProperty("mail.store.protocol", "imaps");
    try {
        Session session = Session.getInstance(props, null);
        Store store = session.getStore();
        store.connect("imap.gmail.com", username, password);
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        Message[] msgs = inbox.getMessages();

        for (Message msg : msgs) {
            try {
                Address[] in = msg.getFrom();
                for (Address address : in) {
                    System.out.println("FROM:" + address.toString());
                }
                Multipart mp = (Multipart) msg.getContent();
                BodyPart bp = mp.getBodyPart(0);
                System.out.println("SENT DATE:" + msg.getSentDate());
                System.out.println("SUBJECT:" + msg.getSubject());
                System.out.println("CONTENT:" + bp.getContent());
            } catch (Exception e) {

                e.printStackTrace();
            }
        }
        // close folder and store (normally in a finally block)
        inbox.close(false);
        store.close();

    } catch (Exception mex) {
        mex.printStackTrace();
    }
}