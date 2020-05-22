scheduler.schedule(() -> {
    try {
        new GetReportList().run(requestId);
    } catch (Exception e) {
        e.printStackTrace();
    }
}, 5, TimeUnit.MINUTES);