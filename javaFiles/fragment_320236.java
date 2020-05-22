new Thread(new Runnable() {
            public void run() {
                for(int x = 0 ; x < 3 ; x++){
                    Log.w("aa",String.valueOf(x));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

new Thread(new Runnable() {
    public void run() {
        for(int x = 0 ; x < 3 ; x++){
            Log.w("bb",String.valueOf(x));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}).start();