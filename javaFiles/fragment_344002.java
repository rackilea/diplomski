CountDownLatch lock = new CountDownLatch(coins);

for(int i = 0; i < coins; i++) {
    Timer timer = new Timer(time, new ActionListener() {
        public void actionPerformed(ActionEvent e) {

        /* All your actionlistener code here */

        lock.countDown(); //Signal to the CountDownLatch that this timer is finished
        }
    });

    timer.setRepeats(false);
    timer.start();

    time += 1000;
}

try {
    lock.await(); //Waits until the CountDownLatch has been counted down "coins" number of times
} catch (InteruptedException ex) {
    ex.printStackTrace(); //or some more sophisticated handling of the error
}