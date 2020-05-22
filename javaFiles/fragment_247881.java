Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            Logger logger2 = Logger.getLogger("Main2");
            logger2.info("Shutting down 2");
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}));