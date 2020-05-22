SharedPreferences prefs = this.getSharedPreferences("com.example.app", Context.MODE_PRIVATE);

if(tbMusic.isChecked()) {
       prefs.edit().putBoolean ("IS_ENABLED_VARIABLE", true ).commit();
    } else {
       prefs.edit().putBoolean ("IS_ENABLED_VARIABLE", false ).commit();
    }