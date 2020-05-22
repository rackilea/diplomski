SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
String FlagValue = preferences.getString("Flag Value","");

if(FlagValue.equals("True")){
    Intent intent=new Intent(this, DashBoard_Activity.class);
    startActivity(intent);
}