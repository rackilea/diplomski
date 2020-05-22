public void onClick(View v) {
    Location lastLocation = mlocManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

    String locationInfo = "Location: " +
        "\nlatitude = " + lastLocation.getLatitude() +
        "\nlongitude = " + lastLocation.getLongitude();

    tv.setText(locationInfo);
}