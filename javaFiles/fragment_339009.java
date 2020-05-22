UserService userService = UserServiceFactory.getUserService();
String thisURL = request.getRequestURI();
if (request.getUserPrincipal() != null) {
    response.getWriter().println("<p>Hello, " +
                                request.getUserPrincipal().getName() +
                                "!  You can <a href=\"" +
                                userService.createLogoutURL(thisURL) +
                                "\">sign out</a>.</p>");
    Properties props = new Properties();
    Session mailSession = Session.getDefaultInstance(props, null);    
    Message msg = new MimeMessage(mailSession);
    String email = userService.getCurrentUser().getEmail();
    //Or
    //String email = "my_admin_account@gmail.com";
    msg.setFrom(new InternetAddress(email));
    msg.addRecipient(Message.RecipientType.TO,
                     new InternetAddress("jesse.sightler@gmail.com"));
    msg.setSubject("Test Email");
    msg.setText("Nobody");
    Transport.send(msg);
    response.getWriter().println("<p>Sent email!</p>");
} else {
    response.getWriter().println("<p>Please <a href=\"" +
                                userService.createLoginURL(thisURL) +
                                "\">sign in</a>.</p>");
}