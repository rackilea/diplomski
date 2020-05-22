Thread t2 = new Thread() { 
        public void run() 
        {
            try {
                synchronized (t1) {
                    while (t1.isAlive()) {
                        t1.wait();
                    }
                }
            } catch (InterruptedException e) {
                return;
            }
            System.out.println("Done.");
        }
    };