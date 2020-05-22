private class MyAuthenticator extends javax.mail.Authenticator 
{
    private PasswordAuthentication authentication;

    public Authenticator() 
    {
         String username = "auth-user";
         String password = "auth-password";
         authentication = new PasswordAuthentication(username, password);
    }

    protected PasswordAuthentication getPasswordAuthentication() 
    {
        return authentication;
    }
}