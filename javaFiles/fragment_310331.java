Thread thr = new Thread() {
        public void run() {
            runProfile();
        }
    };
    thr.setPriority(Thread.MAX_PRIORITY-1);
    thr.start();