public class Third {
Context context;
SharedPreferences sharedPreferences = 
PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
String s = sharedPreferences.getString("txt","");


public Third (Context context){
    this.context=context
}
//...
}