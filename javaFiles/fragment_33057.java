btnCheckBattery = (Button)findViewById(R.id.checkBattery);
        
        intentBatteryUsage = new Intent(Intent.ACTION_POWER_USAGE_SUMMARY);
        ResolveInfo resolveInfo = getPackageManager().resolveActivity(intentBatteryUsage,0);
        
        if(resolveInfo == null){
         Toast.makeText(AndroidIntentBatteryUsageActivity.this, 
           "Not Support!", 
           Toast.LENGTH_LONG).show();
         btnCheckBattery.setEnabled(false);
        }else{
         btnCheckBattery.setEnabled(true);
        }
        
        btnCheckBattery.setOnClickListener(new Button.OnClickListener(){

   public void onClick(View v) {
    // TODO Auto-generated method stub
    startActivity(intentBatteryUsage);
   }});