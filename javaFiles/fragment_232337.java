private void attachShutdownHook(final Process process) {
    Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
            process.destroy();
        }
    });
}