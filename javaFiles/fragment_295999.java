final int mode = Activity.MODE_PRIVATE; 
final String MYPREFS = "MyPreferences_001"; 

// create a reference to the shared preferences object 
SharedPreferences mySharedPreferences; 

// obtain an editor to add data to my SharedPreferences object 
SharedPreferences.Editor myEditor;

mySharedPreferences = getSharedPreferences(MYPREFS, 0); 

// using this instance you can get any value saved.
 mySharedPreferences.getInt("backColor",Color.BLACK); // default value is BLACK set here