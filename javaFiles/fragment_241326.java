public class User implements Serializable
{

    private static User userInstance = null; // the only instance of the class
    private String userName; // userName = the short phone number
    private User(){}
    public static User getInstance()
    {
        if (userInstance == null)
        {
            userInstance = new User();
        }
        return userInstance;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String p_userName)
    {
        userName = p_userName;
    }

    @Override
    public String toString()
    {
        return "User [userName=" + getUserName() + "]";
    }
}