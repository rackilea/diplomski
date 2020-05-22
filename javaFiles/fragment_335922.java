@Override
public void start(Stage primaryStage) {
    final Label countLabel = new Label("You visited this tab 0 time(s) before.");

    // increments visit count every time the tab is activated
    Runnable labelUpdater = new Runnable() {

        private int count = 0;

        @Override
        public void run() {
            countLabel.setText("You visited this tab " + (++count) + " time(s) before.");
        }

    };

    Tab tab1 = new Tab("tab1");
    tab1.setContent(countLabel);

    // add runnable as user data
    tab1.setUserData(labelUpdater);

    TabPane tabPane = new TabPane(tab1, new Tab("tab2"));

    // execute update when a newly selected tab contains a updater 
    tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue != null) {
            Runnable updater = (Runnable) newValue.getUserData();
            if (updater != null) {
                updater.run();
            }
        }
    });

    Scene scene = new Scene(tabPane, 300, 300);

    primaryStage.setScene(scene);
    primaryStage.show();
}