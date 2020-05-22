@Override
 protected void onDestroy() {
  if (mReceiver != null) {
   LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
   mReceiver = null;
  }
  super.onDestroy();
 }