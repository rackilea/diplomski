new java.util.Timer().schedule(
       new java.util.TimerTask() {
            @Override
            public void run() {
                synchronized (lock) {
                    if (isScanning == false) {
                        doScan();
                    }
                }
                stopSelf(); // stop the service
            }
        },
        40000
);