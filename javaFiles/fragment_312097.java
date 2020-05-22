new Thread(new Runnable() {

        @Override
        public void run() {
            for(int i = 0; i < 500; i++) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        addEntry();
                    }
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }
    }).start();