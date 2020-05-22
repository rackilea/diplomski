private final List<InvalidationListener> shutdownListeners = new ArrayList<>();
private final Factory factory = new Factory(shutdownListeners);

@Override
public void start(Stage primaryStage) throws IOException {
    primaryStage.setTitle("Money Saver Program");
    File f = new File("Goal.txt");
    Scene scene;

    if (f.exists()) {
        Parent root = factory.loadFXML(getClass().getResource("MainPage.fxml"));
        scene = new Scene(root, 600, 400);
    } else {
        boolean bool = f.createNewFile();
        Parent root = factory.loadFXML(getClass().getResource("OpeningPage.fxml"));
        scene = new Scene(root, 638, 400);
    }

    primaryStage.setScene(scene);
    primaryStage.show();
}

@Override
public void stop() throws Exception {
    for (InvalidationListener listener : shutdownListeners) {
        try {
            listener.invalidated(null);
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName())
                    .log(Level.WARNING,
                            MessageFormat.format("Shutdown listener {0} yielded exception.", listener),
                            ex);
        }
    }
}