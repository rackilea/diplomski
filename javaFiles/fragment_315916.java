public YourService(){
    ...
    // In case vm shutdown
    Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run()
        {
            // what should be closed if forced shudown
            // ....

            LOG.info(String.format("--- End of ShutDownHook (%s) ---", APPLICATION_NAME));
        }
    });
    ...
}