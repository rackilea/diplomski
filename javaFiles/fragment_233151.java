public static void main(String[] args) {
        FinalizeThis finalizeThis = new FinalizeThis();
        for (int i = 0; i < 1_000_000; i++)
            Thread.yield();
        finalizeThis.loop();
    }