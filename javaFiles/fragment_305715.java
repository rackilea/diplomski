if(ch.isChecked()){             

    SharedPreferences settings = getSharedPreferences(PREFRENCES_NAME, 0);
    settings.edit().putBoolean("check",true).commit();

}