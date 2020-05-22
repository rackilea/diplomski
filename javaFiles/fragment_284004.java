protected void IsPlayServicesAvailable() {
    int resultCode = GoogleApiAvailability.isGooglePlayServicesAvailable(this);

    if (resultCode == ConnectionResult.SUCCESS){
        msgText.setText("isGooglePlayServicesAvailable SUCCESS");
    } else {
        GoogleApiAvailability.getErrorDialog(this, resultCode, 1).show();
    }
}