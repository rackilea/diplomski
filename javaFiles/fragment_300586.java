scheduler.scheduleWithFixedDelay(new Runnable() {
    public void run() {
        try {
            doTheRealWork(); // Such as "sendEmail()"
        } catch (Exception e) {
            e.printStackTrace(); // Or better, use next line if you have configured a logger:
            logger.error("Exception in scheduled e-mail task", e);
        }
    }
}, 0, 1, TimeUnit.SECONDS);