Thread t = new Thread(){
    public void run() {
        while (q.size() > 0) {
            // take off list from front of queue
            // manipulate list and return it to queue/Delete it if no more to
            // add and not reached a threshold.
        }
        //all other code
    };
};
t.start();