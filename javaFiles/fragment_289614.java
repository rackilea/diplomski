private static class OOMRunnable implements Runnable {

    private static final int ALLOCATE_STEP_SIZE = 1_000_000;

    @Override
    public void run() {
        long bytesUsed = 0L;
        List<long[]> eatingMemory = new ArrayList<>();

        while (true) {
            eatingMemory.add(new long[ALLOCATE_STEP_SIZE]);
            bytesUsed += Long.BYTES * ALLOCATE_STEP_SIZE;

            System.out.printf("%d MB allocated%n", bytesUsed / 1_000_000);
        }
    }
}