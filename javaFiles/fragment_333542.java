Platform.runLater(getFxWrapper(yourRunnable));

public static Runnable getFxWrapper(final Runnable r) {
    return new Runnable() {

        @Override
        public void run() {
            try {
                r.run();
            } catch (Exception e) {
                //here you probably want to log something
                System.out.println("Found an exception");
            }
        }
    };
}