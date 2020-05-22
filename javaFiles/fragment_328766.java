@Override public void onResume() {
  super.onResume();
  BusProvider.getInstance().register(this);
}

@Override public void onPause() {
  super.onPause();
  BusProvider.getInstance().unregister(this);
}