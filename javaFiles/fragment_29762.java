Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                updateTextView(restaurants, itemsAdapter);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };

        t.start();