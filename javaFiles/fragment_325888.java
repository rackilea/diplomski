@Override
    public void onDestroy() {

    if(CheckboxData.checked){
     SharedPreferences prefs = getSharedPreferences("private preference", Context.MODE_PRIVATE);
            prefs.edit()
                .putBoolean("CheckboxData",true)
                .commit();
   }
    super. onDestroy();

   }