public void onClick(View view) {

    new Thread(new Runnable() {

        public void run() {

            // execute my task

            synchronized (lock) {
                // stopThread is a volatile boolean changed by another button click
                while (stopThread == false) {
                    lock.wait();
                }
            }

            // Finish the task
        }
    }).start();
}