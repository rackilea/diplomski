Thread thread = new Thread(){
    @Override
    public void run() {
        int a =1;
        while (true){
            try {
                 sleep(1000);
                } catch (InterruptedException e) {
                 e.printStackTrace();
                }
                final int tmp = a;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_mainActivityBalance.setText(String.valueOf(tmp));
                    }
                });
                System.out.println(a);
                a++;
            }
        }
    };
    thread.start();