private Drive createService(Context context) {
   GoogleAccountCredential mCredential = GoogleAccountCredential.usingOAuth2(context.getApplicationContext(), Arrays.asList(new String[]{DriveScopes.DRIVE})).setBackOff(new ExponentialBackOff());
   mCredential.setSelectedAccountName("your_logged_account_name");

   HttpTransport transport = AndroidHttp.newCompatibleTransport();
   JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
   mService = new com.google.api.services.drive.Drive.Builder(
        transport, jsonFactory, mCredential)
        .setApplicationName(context.getString(R.string.app_name))
        .build();

  return mService;
}