final SharedPreferences pref1 = getSharedPreferences("myapp", MODE_PRIVATE);
  String str1= pref1.getString("Stringval", null);
if(str1.equals("app_off")){
   //do something
 }else(str1.equals("app_on")){
   //do something else
 }