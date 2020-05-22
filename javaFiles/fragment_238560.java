final NetworkChangeReceiver networkChangeReceiver = new NetworkChangeReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                super.onReceive(context, intent);
                         // put your code here to check wi-fi and to get ssid value
            }
        };
        final IntentFilter filter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        wifibox.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
                if (isChecked) {
                    registerReceiver(networkChangeReceiver, filter);
                } else {
                    unregisterReceiver(networkChangeReceiver);
                }

            }
        });