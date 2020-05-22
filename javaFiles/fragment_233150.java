class FinalizeThis {
    protected void finalize() {
        System.out.println("finalized!");
    }

    void loop() {
        System.out.println("loop() called");
        for (int i = 0; i < 1_000_000_000; i++) {
            if (i % 1_000_000 == 0)
                System.gc();
        }
        System.out.println("loop() returns");
    }

    public static void main(String[] args) {
        new FinalizeThis().loop();
    }
}