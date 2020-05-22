Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
            Runtime.getRuntime().halt(5);
        }
});