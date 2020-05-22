public class LoginFormValue
{
    public LoginFormValue(String emailAddress, String password)
    {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress()
    {
        return emailAddress;
    }

    public String getPassword()
    {
        return password;
    }

    private String emailAddress;
    private String password;
}