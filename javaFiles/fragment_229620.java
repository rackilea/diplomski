static class TimeThread implements Runnable {
    String name;
    int min;
    int max;
    int random;
    Thread t;

    public void run () {
        while (true){
            random = genRandomInteger(min,max);
            System.out.println("Thread named: " + name + " running for: " 
                               + random + " secconds...");
            try {
                Thread.sleep(random);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }   
        }
    }

    void start(){
        t = new Thread (this);
        t.start();
    }
}