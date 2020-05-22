SharedPreferences sp = getSharedPreferences(SHARED_PREF,getApplicationContext().MODE_PRIVATE);
String cadName = sp.getString(SP_NAME, "");

if (cadName.length()>0){
Log.d("HELENA","info saved : "+cadName);
}
else
Log.d("HELENA","No info saved.");