Properties props = new Properties();
props.put("mail.pop3.host" , "pop.gmail.com");
props.put("mail.pop3.user" , "username");
// Start SSL connection
props.put("mail.pop3.socketFactory" , 995 );
props.put("mail.pop3.socketFactory.class" , "javax.net.ssl.SSLSocketFactory" );
props.put("mail.pop3.port" , 995);

Session session = Session.getDefaultInstance(props , new Authenticator() {
    @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication( "username" , "password");
            }
});
try {
    Store store  = session.getStore("pop3");
    store.connect("pop.gmail.com" , "username" , "password");
    Folder fldr = store.getFolder("INBOX");
    fldr.open(Folder.HOLDS_MESSAGES);
    int count = fldr.getMessageCount();
    System.out.println(count);
} catch(Exception exc) {
    System.out.println(exc + " error");
}