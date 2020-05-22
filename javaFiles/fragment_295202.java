public class InitSplashScreen {
    //...
    public void initUI(PropertyChangeListener listener) throws MalformedURLException {
        showSplashScreen();
        SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
            //...
        };
        worker.addPropertyChangeListener(listener);
        worker.execute();
    }