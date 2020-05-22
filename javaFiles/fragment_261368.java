new Thread(new Runnable() {
    @Override
    public void run() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                tv.setText("changing from different thread.");
            }
        });
    }
}).start();