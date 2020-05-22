Thread t = new Thread() {
    public void run() {
        System.out.println("text");
        // other complex code
    }
 };
 t.start();
 t.join();