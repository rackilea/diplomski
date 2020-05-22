class Clients extends Thread {
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            //do work
        }
        //thread has been interrupted and quits
    }
}