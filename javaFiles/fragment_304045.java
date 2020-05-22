try{
        /* Only activate FaceBook publish install if the user has the FaceBook app installed */
        if (com.facebook.Settings.getAttributionId(getContentResolver()) != null){
        com.facebook.AppEventsLogger.activateApp(this);
        }
    } catch (IllegalStateException e){
        Log.d(TAG, "Facebook Setting Exception again!");
    }