progressLabel.start();
try {
    Thread.sleep(10000);
} catch (InterruptedException ex) {
    Exceptions.printStackTrace(ex);
}
//the above sleep() call will be replace by some time-consuming process. It is there just for testing now

progressLabel.done();