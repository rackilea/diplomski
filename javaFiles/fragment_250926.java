Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    MainActivity.this.startActivity(go);
                    finish();
                }
            }
        };
        t.start();