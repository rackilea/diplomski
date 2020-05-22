private void reconnectSocket() {
        long endTime = startTime + 120000L;

        if(!(System.currentTimeMillis() < endTime)) {
            shutdown = true;
        }   
    }

    private void sleepFewSeconds() {
        try {
            TimeUnit.MILLISECONDS.sleep(20);