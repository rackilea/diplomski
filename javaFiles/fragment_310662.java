final int foo = 10; // Or whatever

Thread t = new Thread(new Runnable() {
    public void run() {
        System.out.println(foo); // Prints 10
    }
});