// fetch the e-mail via imap using javax.mail ..
// Hint: Create session via GreenMailUtil
Session session = GreenMailUtil.getSession(ServerSetupTest.IMAP);
// Use configured host address instead of supplying a 
URLName urlName = new URLName("imap", ServerSetupTest.IMAP.getBindAddress(),
   ServerSetupTest.IMAP.getPort(), null, user.getLogin(),
   user.getPassword());
Store store = session.getStore(urlName);
store.connect();`