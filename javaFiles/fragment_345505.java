Retrieve a {@link SharedPreferences} object for accessing preferences
that are private to this activity. 

This simply calls the underlying
{@link #getSharedPreferences(String, int)} method by 
passing in this activity's class name as the preferences name. @param
mode Operating mode.  

Use {@link #MODE_PRIVATE} for the default
operation, {@link #MODE_WORLD_READABLE} and {@link
MODE_WORLD_WRITEABLE} to control permissions.
@return Returns the single SharedPreferences instance that can be used
to retrieve and modify the preference values.