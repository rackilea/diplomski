onResume(){
   SharedPreferences prefs= getSharedPreferences("prefs", MODE_PRIVATE);
   if(prefs.getBoolean("isShouldReload", false)){
      // Do your reload.
   }
}