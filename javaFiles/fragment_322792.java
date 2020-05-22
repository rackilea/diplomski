public static void main(String[] args) {
    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        public void run() {
            //code to close connection
        }
    }, "Shutdown-thread"));
}