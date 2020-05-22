class MyThing implements Runnable {
    private int x;
    public void run() {
        x = 10;
    }
    public int getX() { return x; }
}

MyThing thing = new MyThing();
Thread t = new Thread(thing);
t.start(); // The thread starts and calls MyThing::run() in itself
t.join(); // wait for t to finish
System.out.println(t.getX());