one = new Thread() {
    public void run() {
        try {
            System.out.println("Does it work?");

            Thread.sleep(1000);

            System.out.println("Nope, it doesnt...again.");
        } catch(InterruptedException v) {
            System.out.println(v);
        }
    }  
};

one.start();