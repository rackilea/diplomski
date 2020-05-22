public static void initSession () {
  if (mySession == null){

    Properties props = new Properties();
    props.put("mail.smtp.host", HOST);
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.connectiontimeout", 1200);
    props.put("mail.smtp.timeout", 1000);

    mySession = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(SMTP_USERNAME, SMTP_PASSWORD);
            }
        });

}