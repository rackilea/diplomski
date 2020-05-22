public void onClick(View view) {

    new Thread(new Runnable() {

        public void run() {

            synchronized (lock) {

                stopThread = true;
                lock.notify();
            }
        }
    }).start();
}