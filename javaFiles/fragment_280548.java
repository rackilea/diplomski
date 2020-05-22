SharedPreferences prefs = mContext.getSharedPreferences("appName", 0);
SharedPreferences.Editor editor = prefs.edit();
Intent intent;
if (prefs.getBoolean("isInitialAppLaunch", false))
{
    intent = new Intent(this, activity_insert_password.class);
    startActivity(intent);
}
else
{
    //First Time App launched, you are putting isInitialAppLaunch to false and calling create password activity.
    editor.putBoolean("isInitialAppLaunch", false);
    intent = new Intent(this, activity_create_password.class);
    startActivity(intent);
}