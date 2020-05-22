new Thread(new Runnable() {
            public void run() {
                update();
                render();
            }
        }).start();