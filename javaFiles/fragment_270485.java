public String sendMailToIt(HttpServletRequest request)
 {
     .....
     JavaMailSenderImpl jMailSender = (JavaMailSenderImpl)sender;

     jMailSender.setUsername(userName);
     jMailSender.setPassword(password);

     ....
     jMailSender.send(mail);

     ....
 }