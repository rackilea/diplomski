private interface eventListener {
  void onEvent(String string);
}

eventListener listener = new eventListener() {
  @Override
  public void onEvent(String string) {
    Log.e(TAG, "onEvent " + string);
  }
};