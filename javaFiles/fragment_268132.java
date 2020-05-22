com.google.android.gms.common.api.GoogleApiClient mGAC 
  = new GoogleApiClient.Builder(Context)
  .addApi(Drive.API)
  .addScope(Drive.SCOPE_FILE)
  .addScope(Drive.SCOPE_APPFOLDER)
  .addConnectionCallbacks( new GoogleApiClient.ConnectionCallbacks() {...})
  .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {...})
  ....
  .build();