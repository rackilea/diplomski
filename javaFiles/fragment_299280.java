public class Preference
{

  // check for username length
   public static String getUserName(Context context)
   {
    return PreferenceManager.getDefaultSharedPreferences(context).getString(
            "username", "");
   }

  public static boolean setUserName(Context context,String username)
  {
    return PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit()
            .putString("username", username).commit();
  } 

// check for password length 
  public static String getPassword(Context context)
  {
    return PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).getString(
            "password", "");
  }


  public static boolean setPassword(Context context,String password)
  {
    return PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).edit()
            .putString("password", password).commit();
  } 


}