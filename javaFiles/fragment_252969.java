SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
String name = preferences.getString("Name", "");
if(!name.equalsIgnoreCase(""))
{
    name = name + "  Sethi";  /* Edit the value here*/
}