protected void IsPlayServicesAvailable() {
    int resultCode = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(this);

    if (resultCode == ConnectionResult.SUCCESS){
        msgText.setText("isGooglePlayServicesAvailable SUCCESS");
    } else {
        GoogleApiAvailability.getInstance().getErrorDialog(this, resultCode, 1).show();
    }
}