public class AppInfo extends Application {

    private static Context context;
    private static String user;

    public void onCreate(){
        super.onCreate();
        AppInfo.context = getApplicationContext();
        user = null;
    }

    public static Context getAppContext()           {return AppInfo.context;}
    public static String getUser()                  {return user;}

    public static void setUser(String user)         {AppInfo.user = user;}
}