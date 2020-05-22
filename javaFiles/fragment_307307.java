Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

        public void run() {
            // Do what you want when the application is stopping
        }
    }));