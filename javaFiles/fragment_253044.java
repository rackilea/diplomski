Handler h1 = new Handler();
Thread t1;

t1 = new Thread(new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            try {
                loop();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    });
    t1.start();


    protected void loop() throws InterruptedException {
    // TODO Auto-generated method stub
     for (i = 0; i < 20; i++) {
         t1.sleep(2000);
         h1.post(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                tv_t1.setText("tv_1: " + i);
            }
        });
     }
}