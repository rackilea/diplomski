public static boolean awaitTermination(JobExecution execution, long timeout) throws InterruptedException {
        final long limit = System.currentTimeMillis() + timeout;
        for (;;) {
            if (null != execution.getExitStatus()) {
                return true;
            }

            if (System.currentTimeMillis() >= limit) {
                return false;
            }

            Thread.sleep(timeout/10);            
        }
    }