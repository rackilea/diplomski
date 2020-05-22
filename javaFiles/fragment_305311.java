for(int i = 0; i < 10; i++) {
    final int FINAL_I = i;
    new Thread("" + FINAL_I) {
        public void run() {
            int sum = 0;
            int upperBound = 22;
            int lowerBound = 1;
            long threadID = Thread.currentThread().getId();
            for (int number = lowerBound; number <= upperBound; number++){
                sum = sum + number + FINAL_I;
            }
            System.out.println("Thread: " + threadID + " is running now and will compute the sum from 1 to " + (upperBound + FINAL_I));
            System.out.println("Thread id " + threadID + " computes sum " + sum);
         }
       }.start();
    }
}