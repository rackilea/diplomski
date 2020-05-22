@Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter("com.saim.logoutReceiver");
        registerReceiver(logoutReceiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        try {
            super.onDestroy();
            unregisterReceiver(logoutReceiver);
        } catch (IllegalArgumentException i) {

        }
    }