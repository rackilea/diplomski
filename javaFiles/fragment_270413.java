SharedPreferences settingsPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        notification = (CheckBoxPreference) findPreference("prefSendNotification");
        notification.setOnPreferenceClickListener(new OnPreferenceClickListener() {
         

   @Override
   public boolean onPreferenceClick(Preference preference) { 
     if(notification.isChecked()){
                     Log.e("PB", "Notifications are currently ON");
                     Pushbots.sharedInstance().setPushEnabled(true);
                     Pushbots.sharedInstance().register();
                 }else{
                     Log.e("PB", "Notifications are currently OFF");
                     Pushbots.sharedInstance().setPushEnabled(false);
                     Pushbots.sharedInstance().unRegister();
                 }
     return true;
   }
});
 }
}