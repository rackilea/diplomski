receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (isOnline()) {
                    hideNoConnectionError();
                } else {
                    showNoConnectionError();
                }
            }
        };