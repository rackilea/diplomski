class SplashScreen extends Task {
    @Override
    public Object call() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                // placeholder for parts of your code
                longRunningOperation();
                guiUpdate();
            }
        });
        return null;
    }
}