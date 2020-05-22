Thread t1 = new Thread(new Runnable() {
                    public void run() {

                        Looper.prepare();
                        ...
 }
 t1.start();