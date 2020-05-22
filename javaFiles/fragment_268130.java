com.google.api.services.drive.Drive mGOOSvc =
  new Drive.Builder(
    AndroidHttp.newCompatibleTransport(),
    new GsonFactory(),
    GoogleAccountCredential.usingOAuth2(Context, Collections.singletonList(DriveScopes.DRIVE_FILE))
   ....
  )
.build();