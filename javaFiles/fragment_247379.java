LocationServices.GeofencingApi.removeGeofences(
mGoogleApiClient,
// This is the same pending intent that was used in addGeofences().
getGeofencePendingIntent()
).setResultCallback(this); // Result processed in onResult().
}