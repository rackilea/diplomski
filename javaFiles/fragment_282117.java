if (value) {
            Handler uiCallback = new Handler(Looper.getMainLooper());
            thread = new Thread() {
                @Override
                public void run() {
                    try {
                        while (!isConnected()) {
                            synchronized (this) {
                                wait(3000);
                            }
                        }
                    } catch (InterruptedException ex) {
                    }

                    uiCallback.post(new Runnable() {
                        @Override public void run() {
                            if(wifiManager.isWifiEnabled()){
                                sendMessageWidget();
                            } else {
                                showWifiSettingsAlert();
                            }
                        }
                    });

                }
            };

            thread.start();
        }