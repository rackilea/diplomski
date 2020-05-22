class DispatcherThread implements Runnable {
    @Override
    public void run() {
        try {
            //open database connection an such...
            //...
            //handle the work here...
        } catch (...) {
            //ALWAYS handle the exceptions
        } finally {
            //cleanup tasks like close database connection
        }
    }
}