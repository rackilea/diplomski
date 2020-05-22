chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

       @Override
       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
          //store isChecked value in shareprefernce

          PreferenceManager.getDefaultSharedPreferences(PopUpInfoActivity.this).edit().putBoolean("value", isChecked).commit();
       }
   }
);