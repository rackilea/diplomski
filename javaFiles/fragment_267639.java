Runtime.getRuntime().addShutdownHook(
    new Thread() {
        public void run() {
            //Your shutdown logic here
        }
    }
);