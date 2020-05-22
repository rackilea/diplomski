Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run() {
        try {
            new File("converted").delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});