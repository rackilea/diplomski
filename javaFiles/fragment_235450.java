SharedPreferences mySharedPreferences=getSharedPreferences("myStore", Context.MODE_PRIVATE);
if(sharedPreferences != null) {
   SharedPreferences.Editor editor = mySharedPreferences.edit();
   editor.remove("jString1");
   editor.commit();
}