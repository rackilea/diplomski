public class MyApp extends Application {

    @Override
    public void init() throws Exception {
        if (!ArgumentsHandler.handle(getParameters()) {
            Platform.exit(); // or throw an exception
        } else {
            Storage storage = Storage.getInstance();
            storage.load();
            if (!storage.isLoadSuccessful()) {
                Platform.exit(); // or throw an exception
            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create Scene and show the primary Stage
    }

    @Override
    public void stop() throws Exception {
        /*
         * Called when the JavaFX application is exiting, such as from
         * a call to Platform.exit(). Note, however, that in my experience
         * this method is *not* called when Platform.exit() is called inside
         * the "init" method. It is called if Platform.exit() is called from
         * inside the "start" method or anywhere else in the application once
         * it is properly started.
         *
         * This is where you could perform any necessary cleanup.
         */
    }

}