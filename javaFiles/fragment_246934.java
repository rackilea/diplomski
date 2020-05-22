@Override
protected void onMessage(Context context, Intent intent) {
    //Bundle[{CMD=RST_FULL, from=google.com/iid}]
    Bundle bundle = intent.getExtras();
    if (bundle != null) {
        if (!bundle.containsKey("CMD")) {
            handleMessage(context, intent);
        }
    }
}