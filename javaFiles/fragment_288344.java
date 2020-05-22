//threads will increment the value of count by 1 and will wait if its value is
   //less than 4.
   public synchronized void increaseCount() throws InterruptedException {
        count++;
        if (count < 4) {
            wait();
        }
    }

    //4th thread will come inside this method, it will set the count value to 0
    //and will notify other threads
    public synchronized void releaseCount() throws InterruptedException {
        if (count >= 3) {
            count = 0;
            notifyAll();
        }

    }