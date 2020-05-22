final Thread t1, t2, t3;

    t1 = new Thread(new Runnable() {
        public void run() {
            //do some long stuffs
        }
    });

    t2 = new Thread(new Runnable() {
        public void run() {
            //do some long stuffs
        }
    });

    t3 = new Thread(new Runnable() {
        public void run() {
            try {
                t1.join();
                t2.join();
                // t1 & t2 have finished
                // continue with t3 stuff
            } catch (InterruptedException e) {
                //handle it
            }
        }
    });

    t1.start();
    t2.start();
    t3.start();