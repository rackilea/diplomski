new Thread(new Runnable() {
            @Override
            public void run() {
                for(x = 0; x < colours.size(); x++) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            light.setBackgroundColor(colours.get(x));
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();