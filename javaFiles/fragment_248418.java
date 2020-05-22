SharedPreferences sharedPref = getSharedPreferences("Preference",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

//here "off" is a default value.
String state = editor.getString("switch_state","off");

if(state.equals("off"))
    //Switch is off
if(state.equals("on"))
    //Switch is on