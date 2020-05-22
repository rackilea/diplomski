@Override
  @SuppressWarnings({"MissingPermission"})
  public void onStop() {
    mgr.removeUpdates(this);

    super.onStop();
  }