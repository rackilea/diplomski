//             milli min  hour  day 30day
long days_30 = 1000 * 60 * 60 * 24 * 30;
SharedPreferences pref = getApplicationContext().getSharedPreferences("DataCountService", 0);
long oldTime = pref.getLong("smstimestamp");
if(System.currentTimeMillis() - oldTime > days_30){
      // here, more than 30 days
}