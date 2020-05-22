new Thread(new Runnable() {

            @Override
            public void run() {
                connectToService (url);

            }
        }).start();