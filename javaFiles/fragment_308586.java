ScheduledExecutorService service = null;
    service = Executors.newSingleThreadScheduledExecutor();
    try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(testFile, true));
        service.scheduleAtFixedRate(() -> {
            try {
                bw.write("Curr Time: " + LocalTime.now() + "\n");
                bw.flush();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }, 1, 1, TimeUnit.SECONDS);

    } catch (IOException ioe) {
        ioe.printStackTrace();
    }