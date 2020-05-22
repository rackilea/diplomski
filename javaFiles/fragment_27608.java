@Override
public void onDestroy() {
   super.onDestroy();
   //Always unbind the connection with the store, otherwise performance degradation of the device may follow.
   if (mHelper != null) {
      mHelper.disposeWhenFinished();
      mHelper = null;
   }
}