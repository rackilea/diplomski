private void init(){
    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "IP");
    props.put("mail.smtp.port", "PORT");

    try {

      session = Session.getInstance(props,
              new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    //returning user name and password to connect to email server
                    return new PasswordAuthentication("Username", "password");
                }
              });
     } catch(RuntimeException e) {
         e.printStackTrace(); // for example
     }
}