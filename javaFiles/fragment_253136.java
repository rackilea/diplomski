IntentFilter filter = new IntentFilter();
filter.addAction("CHANGE_HAS_BEEN_CALLED");
registerReceiver(new BroadcastReceiver() {
    @Override public void onReceive(Context context, Intent intent) {
       if (start==false){
           startDone();

        } else{  
            //Do something          
        }
    }
}, filter);