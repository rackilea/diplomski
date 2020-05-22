class MyClass {
    private Random rng = new Random();

    public void run() {
        int i = rng.nextInt(100);
        if(i < 25) {
            // execute it
        }
    }
}