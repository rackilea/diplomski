Runtime.getRuntime().addShutdownHook(new Thread() {

        public void run() {
            System.out.println("BYE BYE");
        }
    });