@Override
    protected void onHandleIntent(Intent intent) {
 // Get the transition type.
        int geofenceTransition = geofencingEvent.getGeofenceTransition();

        // Test that the reported transition was of interest.
        if (geofenceTransition == Geofence.GEOFENCE_TRANSITION_EXIT){
             sendNotification("your notification details");
             sendAPICall("some token","body","my call");
        } 
}