SharedPreferences sharedPref = getSharedPreferences("Preference",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

//if your switch is off, you can write on your Shared Preference
editor.putString("switch_state","off");
//if on, instead
editor.putString("switch_state","on");

//to save your preference
editor.commit();