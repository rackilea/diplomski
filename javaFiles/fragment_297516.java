public void run() {
        long warmUp = 20000;

        long milli0 = System.currentTimeMillis();
        long nano0 = System.nanoTime();
        while (true) {
            long milli1 = System.currentTimeMillis();
            long nano1 = System.nanoTime();
            if (warmUp > 0) {
                warmUp--;
            } else {
                if (nano1 < nano0) {
                    log("WARNING: Nanotime goes back by " + (nano1 - nano0) + " ns");
                    warmUp = 20000;
                } else
                if (nano1 - nano0 > SPIKE) {
                    log("WARNING: Nanotime gap: " + (nano1 - nano0)/MILLIS_PER_NANO + " ms. System time delta: " + (milli1 - milli0) + " ms.");
                    warmUp = 20000;
                }

            }
            nano0 = nano1;
            milli0 = milli1;
        }
    }