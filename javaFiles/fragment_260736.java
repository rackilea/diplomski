public class Global
{
    private static String userName;

    public static void setUserName(final String userName)
    {
        Global.userName = userName;
    }

    public static String getUserName()
    {
       return Global.userName;
    }

}