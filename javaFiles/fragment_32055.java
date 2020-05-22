private final BroadcastReceiver receiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals("com.mypackage.ACTION_PAUSE_MUSIC")){
            //Do whatever you want. Ex. Pause
        }
        //Similarly this can be done for all actions
    }};