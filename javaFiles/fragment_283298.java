private Dialog offline;

@Override
protected void onResume() {
    if (netStateReceiver == null) {
        netStateReceiver = new BroadcastReceiver() {
            @Override
        public void onReceive(final Context context, Intent intent) {

            if (!CheckNet()) {
                if(offline==null || !offline.isShowing()){
                    offline = new Dialog(context, android.R.style.Theme_Light);
                }
                ...
            } else {
                //User became online (dismiss offline dialog):
                if (offline!=null && offline.isShowing()) {
                    offline.dismiss();
                }
            }