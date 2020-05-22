public static void main(String[] args) {
{
    try
    {
        Email se = new SimpleEmail();

        se.setHostName("smtp.googlemail.com");
        se.setSmtpPort(465);
        se.setAuthenticator(new DefaultAuthenticator("email@gmail.com", "password"));
        se.setSSLOnConnect(true);


        se.addTo("email@gmail.com");
        se.setFrom("email@gmail.com");
        se.setSubject("Test email");
        se.setMsg("Hi there");
        se.send();
    }
    catch(EmailException e) {
        System.out.println("Uh oh! It doesn't work!");
    }
}