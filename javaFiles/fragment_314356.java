import java.net.Authenticator;
import java.net.PasswordAuthentication;

Authenticator authenticator = new Authenticator() 
{
    @Override
    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication("usr", "pass".toCharArray());
    }
};

Authenticator.setDefault(authenticator );