@Override
  @SuppressWarnings({"MissingPermission"})
  public void onStart() {
    super.onStart();

    mgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3600000,
      1000, this);
  }