int port = 587;
String host = "smtp.gmail.com";
String user = "username@gmail.com";
String pwd = "email password";

try {
    Properties props = new Properties();
    // required for gmail 
    props.put("mail.smtp.starttls.enable","true");
    props.put("mail.smtp.auth", "true");
    // or use getDefaultInstance instance if desired...
    Session session = Session.getInstance(props, null);
    Transport transport = session.getTransport("smtp");
    transport.connect(host, port, user, pwd);
    transport.close();
    System.out.println("success");
 } 
 catch(AuthenticationFailedException e) {
       System.out.println("AuthenticationFailedException - for authentication failures");
       e.printStackTrace();
 }
 catch(MessagingException e) {
       System.out.println("for other failures");
       e.printStackTrace();
 }