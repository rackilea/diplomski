@Override
protected void onPostExecute(Void v) {
    if (!this.isCancelled()){
        Log.d(TAG, "chiedo aggiornamento updateUI");
        if (mCallbacks != null) {
            mCallbacks.onSubscriptionsUpdated();
        }
    }
}