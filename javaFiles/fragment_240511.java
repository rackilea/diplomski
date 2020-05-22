public class MyPrefs {

     SharedPreferences settings;
     SharedPreferences.Editor editor;


     public MyPrefs(Context context){
        settings = PreferenceManager.getDefaultSharedPreferences(context);
        editor = settings.edit();
     }

     public void saveName(String name){
          editor.putString("name", name).commit();
     } 

}