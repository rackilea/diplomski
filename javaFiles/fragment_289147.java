Thread t = new Thread(){
    public void run() {
        while (q.size() > 0) {
            // take off list from front of queue
            // manipulate list and return it to queue/Delete it if no more to
            // add and not reached a threshold.
        }
    };
};
t.start();
t.join();//waits for the thread to finish execution.
//rest of your code.