@Override
protected void onRegistered(Context context, String registrationId) {
     Log.i(TAG, "Device registered: regId = " + registrationId);
     //displayMessage(context, getString(R.string.gcm_registered));
     //ServerUtilities.register(context, registrationId);
     //1. Store this id to application Prefs on each request of device registration
     //2. Clear this id from app prefs on each request of device un-registration  
     //3. Now add an if check for new registartion id to server, you can write a method on server side to check if this reg-id matching for this device or not (and you need an unique identification of device to be stored on server)
     //4. That method will clear that if id is matching it meanse this is existing reg-id, and if not matching this is updated reg-id.
     //5. If this is updated reg-id, update on server and update into application prefs.
}