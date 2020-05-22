public class PopUpApp extends Application {

    Stage popupStage;
    Stage primaryStage;

    @Override
    public void start(Stage stage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);
            primaryStage = stage;

            initPopUpStage();

            // When the Pop-Up stage is showing, do not handle any action on the
            // main GUI
            root.disableProperty().bind(popupStage.showingProperty());

            Button b = new Button("Open deck");
            b.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {

                    // Add some ToggleButtons to simulate the cards
                    VBox vbox = new VBox();
                    vbox.setAlignment(Pos.CENTER);

                    List<ToggleButton> toggles = new ArrayList<ToggleButton>();

                    for (int i = 0; i < 4; i++) {
                        ToggleButton tb = new ToggleButton("Card " + i + 1);
                        toggles.add(tb);
                    }
                    vbox.getChildren().addAll(toggles);

                    Scene sc = new Scene(vbox, 300, 300);
                    popupStage.setScene(sc);

                    // On close request check for the condition
                    popupStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

                        @Override
                        public void handle(WindowEvent event) {
                            Boolean readytoClose = false;
                            for (ToggleButton toggle : toggles) {
                                if (toggle.isSelected()) {
                                    readytoClose = true;
                                    break;
                                }
                            }

                            // Consume the event a show a dialog
                            if (!readytoClose) {
                                event.consume();
                                Alert alert = new Alert(AlertType.INFORMATION,
                                        "At least one card has be to be selected!");
                                alert.showAndWait();
                            }
                        }
                    });

                    popupStage.show();

                }
            });

            root.setCenter(b);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initPopUpStage() {
        popupStage = new Stage();
        popupStage.initOwner(primaryStage);
        popupStage.initStyle(StageStyle.UNDECORATED);
        // On focus loss, close the window
        popupStage.focusedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

                // Rather than popupStage.close(); fire the event manually
                if (!newValue)
                    popupStage.fireEvent(new WindowEvent(popupStage, WindowEvent.WINDOW_CLOSE_REQUEST));
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}