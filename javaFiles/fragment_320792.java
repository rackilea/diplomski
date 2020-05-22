public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
  if (System.currentTimeMillis() - lastShownTimestamp > 20000) {

    // TODO: show latest data on screen

    lastShownTimestamp = System.currentTimeMillis();
  }
}